package properties;

import BasicClass.ConnectToAcc;
import Services.Search_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;


@WebServlet(name="properties.Admin",urlPatterns={"/properties.Admin"})
public class Admin extends HttpServlet{

    Search_info search = new Search_info();
    Seller callFunction = new Seller();
    Client numCheck = new Client();
    ConnectToAcc connect = new ConnectToAcc();
    String users_acc = "select * from mobiletele.users_acc";

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();



        //LOGOUT BUTTON
        if(request.getParameter("logout") != null) {
            session.invalidate(); //clear session variables
            response.sendRedirect("/index.jsp");

         // seller2ndVerification.jsp
        }else if(request.getParameter("Login1") != null) { // log in button pressed

            String hashkeyAdmin = request.getParameter("password");

            //hash key verification
            if (hashkeyAdmin.equals("820a207799f8a70c59wsc0965a1fb98b5")) {


                response.sendRedirect("/adminActions.jsp");// go to seller account

            } else {

                session.setAttribute("errorVeri","Wrong Admin key!"); //set error message blank
                response.sendRedirect("/admin2ndVerification.jsp");


            }

         //CREATE A SELLER
        }else if (request.getParameter("newSeller") != null) {

            session.setAttribute("error",""); //set error message blank

            response.sendRedirect("/newSeller.jsp"); // go to new seller form

        //INSERT A SELLER
        }else if (request.getParameter("reg seller") != null) {

            session.setAttribute("error","username");

            //ERRORS FOR EMPTY FIELDS
            if(request.getParameter("username").isEmpty() || ( request.getParameter("password").isEmpty() || request.getParameter("password2").isEmpty())) {   //blank fields

                session.setAttribute("error","Please fill all the fields!");

             //PASSWORDS ARE THE SAME?
            }else if(!request.getParameter("password").equals(request.getParameter("password2"))){  //not same passwords

                session.setAttribute("error","Passwords does not match!");


             //USERNAME EXIST?
            }else if(!(connect.infoExist(request.getParameter("username"),"username_id",users_acc))){

                session.setAttribute("error","Username already exists!");


            //SUCCESS
            }else{

                //INSERT INTO USERS_ACC
                connect.insertAccount(request.getParameter("username"),request.getParameter("password"),"seller");
                session.setAttribute("error","Seller inserted!");


            }

            response.sendRedirect("/newSeller.jsp");


        //RETURN TO ADMIN ACTIONS (from new seller jsp page)
        }else if (request.getParameter("goToActions") != null) {

            session.setAttribute("error","");// SET ERROR EMPTY AGAIN

            response.sendRedirect("/adminActions.jsp");

        //DELETE USERS
        }else if (request.getParameter("deleteUser") != null) {
            session.setAttribute("deleteSuccess","");// SET ERROR EMPTY AGAIN

            if(deleteUser(request.getParameter("delAcc"))){
                session.setAttribute("deleteSuccess","User deleted successfully");


            }else {

                session.setAttribute("deleteSuccess","Something went wrong,try again later");

            }

            response.sendRedirect("/adminActions.jsp"); // go to admin form


        //DELETE PROGRAM
        }else if (request.getParameter("delProg") != null) {
            session.setAttribute("deleteProgSuccess","");// SET ERROR EMPTY AGAIN

            if (!(connect.infoExist(request.getParameter("delProgram"),"prog_name","select * from mobiletele.programs"))) {

                if(deleteSmth("programs","prog_name = '"+request.getParameter("delProgram")+"' ")){

                    session.setAttribute("deleteProgSuccess","User deleted successfully");


                }else{
                    session.setAttribute("deleteProgSuccess","Something went wrong,try again later");
                }

            } else {
                session.setAttribute("deleteProgSuccess","This program name does not exist");
            }

            response.sendRedirect("adminActions.jsp");


        //NEW PROGRAM
        }else if (request.getParameter("newProg") != null) {

            response.sendRedirect("/newProgram.jsp");

            session.setAttribute("error",""); //set error message blank

            session.setAttribute("fromWhere","insert");

        //CHANGE PROGRAMS INFO
        }else if(request.getParameter("changeProg") != null) {

            session.setAttribute("error", ""); //set error message blank

            response.sendRedirect("/newProgram.jsp");

            session.setAttribute("fromWhere","update");



         //UPDATE OR INSERT A PROGRAM
        }else if(request.getParameter("createProgram") != null) {


            //check if program name exist
            System.out.println(request.getParameter("progname2"));

            //CHECK IF DOES NOT EXIST (UPDATE)
            if (session.getAttribute("fromWhere").toString().equals("update") && connect.infoExist(request.getParameter("progname2"), "prog_name", "select * from mobiletele.programs")) {

                session.setAttribute("error", "Program does not exist!");

            //CHECK IF NAME ALREADY EXISTS (INSERT)
            }else if (session.getAttribute("fromWhere").toString().equals("insert") && !connect.infoExist(request.getParameter("progname2"), "prog_name", "select * from mobiletele.programs")) {

                session.setAttribute("error", "Program name already exist!");


            } else if (request.getParameter("progname2").isEmpty() || (request.getParameter("inTalk").isEmpty() || request.getParameter("outTalk").isEmpty() || request.getParameter("costPerMonth").isEmpty())) {

                session.setAttribute("error", "please fill all the fields!");

                //Check if all fields except program name are numbers
            } else if (!(numCheck.numberChecker2(request.getParameter("inTalk")) && numCheck.numberChecker2(request.getParameter("outTalk")) && numCheck.numberChecker2(request.getParameter("costPerMonth")))) {

                session.setAttribute("error", "Be sure to use numbers in all the fields except program name!");


             //UPDATE PROGRAM
            } else {

                if (session.getAttribute("fromWhere").toString().equals("update") && updateProgram(request.getParameter("progname2"), request.getParameter("inTalk"), request.getParameter("outTalk"), request.getParameter("costPerMonth"))) {

                    session.setAttribute("error", "Program changes were successfully completed");


                }else if (session.getAttribute("fromWhere").toString().equals("insert") && createProgram(request.getParameter("progname2"), request.getParameter("inTalk"), request.getParameter("outTalk"), request.getParameter("costPerMonth"))){

                    session.setAttribute("error", "Program creation were successfully completed");


                }else {

                    session.setAttribute("error", "Something went wrong, please try again later");

                }
            }

            response.sendRedirect("/newProgram.jsp");



         //GIVE PROGRAM TO CLIENT
        }else if(request.getParameter("giveProg") != null){

            //DISPLAY ERROR OR SUCCESS MESSAGE
            session.setAttribute("giveProg", callFunction.giveOrUpdateClientProg(request.getParameter("afmCode"), request.getParameter("progName")));


            // give a call history to the specific client
            if(callFunction.giveOrUpdateClientProg(request.getParameter("afmCode"), request.getParameter("progName")).equals("Clients program saved with success")){
                callFunction.giveHistory.giveCallHistory(request.getParameter("afmCode"));
            }

            response.sendRedirect("adminActions.jsp");

        }

    }


    //UPDATE PROGRAMS INFORMATION
    protected  boolean updateProgram(String progname,String inTalk,String outTalk,String costPerMonth) {
        boolean success=false;

        System.out.println("1");
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

            String query = "UPDATE programs SET inTalk = ? ,outTalk = ?,costPermonth= ? WHERE prog_name = ?";
            PreparedStatement preparedStmt = myConn.prepareStatement(query);

            preparedStmt.setString(1,inTalk);
            preparedStmt.setString(2,outTalk);
            preparedStmt.setString(3,costPerMonth);
            preparedStmt.setString(4,progname);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            myConn.close();

            success=true;

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return success;
    }




    //INSERT A NEW PROGRAM IN DATABASE
    protected boolean createProgram(String progname,String inTalk,String outTalk,String costPerMonth){
        boolean success=false;
        System.out.println("2");
        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

            // INSERT IN DATABASE
            String query = " insert into programs (prog_name,inTalk,outTalk,costPermonth)"
                    + " values (?,?,?,?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1,progname);
            preparedStmt.setString(2,inTalk);
            preparedStmt.setString(3,outTalk);
            preparedStmt.setString(4,costPerMonth);

            // execute the prepared statement
            preparedStmt.execute();

            myConn.close();

            success=true;

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return success;
    }





    //DELETE SELLER OR CLIENT
    protected boolean deleteUser(String username)  {
        boolean success= false;
            //check if username exists
            if(!(connect.infoExist(username,"username_id",users_acc))){


                String prop = search.searchInfo(username,users_acc,"property");
                //check if users property is client or seller

                //DELETE A SELLER
                if(prop.equals("seller")){

                    //delete seller form users_acc schema
                    if(deleteSmth("users_acc","username_id = '"+username+"' ")){
                        success= true;
                        System.out.println("success");
                    }else{
                        System.out.println("seller sok");

                    }


                //DELETE A CLIENT
                }else if (prop.equals("client")) {

                    //delete from clients_programs
                    if(deleteSmth("clients_programs","afm_code = '"+search.searchInfo(username,"select * from mobiletele.client_info","AFM")+"'")){

                        //delete from client info
                        System.out.println("success1");

                        if(deleteSmth("client_info","username_id = '"+username+"' ")){

                            //delete from users_acc
                            System.out.println("success2");

                            if(deleteSmth("users_acc","username_id = '"+username+"' ")){

                                success= true;
                                System.out.println("success3");
                            }
                        }
                    }
                //WRONG
                }else{
                    System.out.println("You can not delete an admin!");
                }



            }else {

                System.out.println("username does not exist");

            }

        return success;
    }




    //DELETE FUNCTION
    protected boolean deleteSmth(String db,String where) {

        boolean success= false;
        String query1 = "DELETE FROM  "+db + " WHERE "+ where;
        System.out.println(query1);


        Statement stmt = null;
        Connection myConn = null;

        //Creates connection to database
        try {
            System.out.println("5");
             myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");
            stmt = myConn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Connection Error", JOptionPane.WARNING_MESSAGE);
        }

        //Execute the SQL statment for deleting records
        try {
            System.out.println("6");
            stmt.executeUpdate(query1);
            System.out.println("7");

            //This closes the connection to the database
            myConn.close();
            //This closes the dialog
            success = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return  success;
    }
}

