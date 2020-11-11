package properties;

import BasicClass.ConnectToAcc;
import properties.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="properties.Seller",urlPatterns={"/properties.Seller"})
public class Seller extends HttpServlet{

    String sqlPrograms = "select * from mobiletele.programs";
    String sqlClientInfo = "select * from mobiletele.client_info";
    String users_acc = "select * from mobiletele.users_acc";
    String sqlClients_programs = "select * from mobiletele.clients_programs";
    ConnectToAcc check = new ConnectToAcc();

    Client giveHistory = new Client();


    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();




        // seller2ndVerification.jsp
        if (request.getParameter("Login1") != null) { // log in button pressed

            String hashkeySeller = request.getParameter("password");

            //hash key verification
            if (hashkeySeller.equals("820a20779986845ef4b90965a1fb98b5")) {


                response.sendRedirect("/sellerActions.jsp");// go to seller account

            } else {

                session.setAttribute("errorVeri2", "Wrong seller key!");
                response.sendRedirect("/seller2ndVerification.jsp");// go to seller account

            }

        } else if (request.getParameter("newClient") != null) {

            response.sendRedirect("/newClient.jsp"); // go to new client form


        } else if (request.getParameter("showProg") != null) {//SHOW PROGRAMS

            try {


                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");
                Statement myStmt = myConn.createStatement();
                String sql = "select * from mobiletele.programs";
                ResultSet rs = myStmt.executeQuery(sql);

                //CHECK THE USERNAME WITH THE EXACT PASSWORD EXISTS

                while (rs.next()) {

                    //Display values
                    writer.println("Program name: " + rs.getString("prog_name"));
                    writer.println("Charge per minute in our communication network: " + rs.getString("inTalk"));
                    writer.println("Charge per minute out of our communication network: " + rs.getString("outTalk"));
                    writer.println("Cost per month: " + rs.getString("costPermonth"));
                    writer.println("");
                }


                // Clean-up environment
                rs.close();
                myStmt.close();
                myConn.close();

            } catch (SQLException e) { //if sql connection fail

                e.printStackTrace();
            }

        } else if (request.getParameter("showClients") != null) {// SHOW CLIENTS

            try {


                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");
                Statement myStmt = myConn.createStatement();
                String sql = "select * from mobiletele.client_info";
                ResultSet rs = myStmt.executeQuery(sql);


                //Display users info


                while (rs.next()) {

                    //Display values
                    writer.println("First name: " + rs.getString("First_name"));
                    writer.println("Last name: " + rs.getString("Last_name"));
                    writer.println("Afm code: " + rs.getString("AFM"));
                    writer.println("Phone number: " + rs.getString("PhoneNumber"));
                    writer.println("");
                }


                // Clean-up environment
                rs.close();
                myStmt.close();
                myConn.close();

            } catch (SQLException e) { //if sql connection fail

                e.printStackTrace();
            }


         // GIVE/CHANGE PROGRAM
        } else if (request.getParameter("giveProg") != null) {


            //DISPLAY ERROR OR SUCCESS MESSAGE
            session.setAttribute("giveProg2", giveOrUpdateClientProg(request.getParameter("afmCode"), request.getParameter("progName")));


            // give a call history to the specific client
            if (giveOrUpdateClientProg(request.getParameter("afmCode"), request.getParameter("progName")).equals("Clients program saved with success")) {
                giveHistory.giveCallHistory(request.getParameter("afmCode"));
            }

            response.sendRedirect("sellerActions.jsp");


        }else if (request.getParameter("goToActions") != null) {

            session.setAttribute("error","");// SET ERROR EMPTY AGAIN

            response.sendRedirect("/sellerActions.jsp");



        //CREATE USER ACC VIA FROM SELLERS SIDE
        } else if (request.getParameter("create_acc_via_seller") != null) {

            Client check2 = new Client();

            //check for empty fields
            if (request.getParameter("fname").isEmpty() || request.getParameter("lname").isEmpty() || request.getParameter("afm").isEmpty() || request.getParameter("pnumber").isEmpty() || request.getParameter("username").isEmpty() || request.getParameter("password2").isEmpty()) {

                session.setAttribute("accError", "Please fill all the fields!");

                //check if passwords are the same
            } else if (!(request.getParameter("password2").equals(request.getParameter("password3")))) {

                session.setAttribute("accError", "Passwords are not the same!");


                //check if username already exists
            } else if (!(check.infoExist(request.getParameter("username"), "username_id", users_acc))) {

                session.setAttribute("accError", "Username already exists!");


            } else if (!(check2.numberChecker(request.getParameter("afm")))) {

                session.setAttribute("accError", "Wrong afm, please insert an afm code with 10 numbers!");

            } else if (!(check2.numberChecker(request.getParameter("pnumber")))) {

                session.setAttribute("accError", "Wrong phone number, please insert a phone number with 10 numbers!");

            } else {

                //INSERT INTO users_acc database

                check.insertAccount(request.getParameter("username"), request.getParameter("password2"), "client");

                //INSERT INTO client_info database
                check2.insertClient(request.getParameter("username"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("afm"), request.getParameter("pnumber"));

                session.setAttribute("accError", "Client created with success!");

            }

            response.sendRedirect("/newClient.jsp");// go to seller account


            //CREATE BILL
        } else if (request.getParameter("createBill") != null) {

            // field errors
            if (check.infoExist(request.getParameter("afmCode2"), "afm_code", "select * from mobiletele.clients_programs")) { // AFM DOES NOT EXIST


                session.setAttribute("billError", "The AFM code is wrong or does not exist");


            } else {// UPDATE OR INSERT


                   //UPDATE

                    if(!(updateClientProg("update clients_programs set summary = ? where afm_code = ?",request.getParameter("afmCode2"),"0"))){


                        session.setAttribute("billError", "Bill created successfully!");

                    }else{

                        session.setAttribute("billError", "Something went wrong!");

                    }
            }

            response.sendRedirect("/sellerActions.jsp");


        } else if (request.getParameter("logout") != null) {  //LOGOUT BUTTON

            session.invalidate();

            response.sendRedirect("/index.jsp");
        }
    }





    //Change or give program to a client function
    protected String  giveOrUpdateClientProg(String afm, String prog_name)  {

        String success= "something went wrong";

        // field errors
        if (check.infoExist(afm, "AFM", sqlClientInfo)) { // AFM DOES NOT EXIST

            success= "The AFM code is wrong or does not exist";

        } else if (check.infoExist(prog_name, "prog_name",sqlPrograms)) {// PROGRAM NAME DOES NOT EXIST

        //    writer.println("The program name is wrong or does not exist"); //afm does not exist
            success= "The program name is wrong or does not exist";

        } else {// UPDATE OR INSERT


            //UPDATE
            if (!(check.infoExist(afm, "afm_code", sqlClients_programs))) { // Check if needs an insert or an update by checking if the row already exists


                //go back to main seller page
                if (!(updateClientProg("update clients_programs set prog_name = ? where afm_code = ?", afm, prog_name))) {

                    success="Clients program saved with success";
                } else {

                    success= "something went wrong";
                }


            } else {//INSERT NEW VALUE
                try {

                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

                    // INSERT IN DATABASE
                    String query = " insert into clients_programs (prog_name, afm_code,summary)"
                            + " values (?,?,?)";

                    // create the mysql insert prepared statement
                    PreparedStatement preparedStmt = myConn.prepareStatement(query);
                    preparedStmt.setString(1, prog_name);
                    preparedStmt.setString(2, afm);
                    preparedStmt.setString(3, "");


                    // execute the prepared statement
                    preparedStmt.execute();

                    myConn.close();

                    success="Clients program saved with success";

                } catch (Exception e) {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                }
            }


        }

        return success;
    }





    //update  clients program
    protected   boolean updateClientProg(String update,String var1,String var2){
        int summary =0;
        boolean error= true;
        try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

                // create the java mysql update preparedstatement
                String query = update;
                PreparedStatement preparedStmt = myConn.prepareStatement(query);




            // update summary (bill) for a client
            if(update.equals("update clients_programs set summary = ? where afm_code = ?")){



                //**CLIENTS_PROGRAMS SCHEMA**
                try {

                    Statement myStmt = myConn.createStatement();
                    ResultSet rs = myStmt.executeQuery("select * from mobiletele.clients_programs");

                    while (rs.next()){
                        //find exact afm code in clients_programs
                        if(rs.getString("afm_code").equals(var1) ) {

                            //if summary field is not empty (client has not yet paid previous bill)
                            if(!(rs.getString("summary").equals(""))){

                                //previous bill + new bill
                                summary = Integer.parseInt(rs.getString("summary")) + Integer.parseInt(rs.getString("summary"));

                            }else{//if summary field is empty then search in programs
                                // **PROGRAMS SCHEMA**
                                //search for cost/permonth in programs with prog_name as search key
                                try {
                                    Statement myStmt2 = myConn.createStatement();
                                    ResultSet rs2 = myStmt2.executeQuery("select * from mobiletele.programs");


                                    //CHECK THE USERNAME WITH THE EXACT PASSWORD EXISTS
                                    while (rs2.next()) {
                                        if (rs2.getString("prog_name").equals(rs.getString("prog_name")))
                                        {

                                            summary = Integer.valueOf(rs2.getString("costPermonth")); //get cost per month
                                            System.out.println(summary);

                                            break; //stop while
                                        }
                                        System.out.println(summary);

                                    }


                                } catch (SQLException e) { //if sql connection fail
                                    e.printStackTrace();
                                }

                            }

                            System.out.println(summary);


                            break; //stop while
                        }

                    }

                } catch (SQLException e){ //if sql connection fail

                    e.printStackTrace();
                }

                System.out.println(summary);

                var2 = String.valueOf(summary); //set var2 value(cost)
            }





            preparedStmt.setString(1,var2); // summary/program name
            preparedStmt.setString(2,var1); //afm


            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            myConn.close();
            error=false;


         } catch (Exception e) {
             System.err.println("Got an exception!");
             System.err.println(e.getMessage());
         }


        return  error; // updated or not
    }

}
