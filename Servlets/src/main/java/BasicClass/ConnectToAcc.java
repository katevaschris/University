package BasicClass;


import Services.MD5encryption;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="BasicClass.ConnectToAcc",urlPatterns={"/BasicClass.ConnectToAcc"})

public class ConnectToAcc extends HttpServlet {
    MD5encryption encrypt = new MD5encryption();

    String sql = "select * from mobiletele.users_acc";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int error;
        HttpSession session = request.getSession();


        PrintWriter writer = response.getWriter();

        ConnectToAcc check = new ConnectToAcc();


        //LOGIN BUTTON
        if (request.getParameter("Log in button") != null) { // log in button pressed

            String username = request.getParameter("username1");
            String password = request.getParameter("password1");

            error = check.loginCheck(username,password);// Call login check function


            //Create session
            session.setAttribute("username",username);

            if (error==1){

                session.setAttribute("LogError", "Wrong username or password!"); //Show error
                response.sendRedirect("/index.jsp");


            }else if(error==0){ //client acc
                session.setAttribute("property","client");

                //set setAttributes of client's page
                request.setAttribute("value", session.getAttribute("username"));
                request.setAttribute("value2", session.getAttribute("property"));

                //Check if a client didnt complete his registration
                if(infoExist(username,"username_id","select * from mobiletele.client_info")){
                    response.sendRedirect("/finalStepClient.jsp");
                }else{
                    response.sendRedirect("/client_page.jsp");

                }
            }else if (error==2){//seller acc

                session.setAttribute("property","seller");

                //set setAttributes of seller's page
                request.setAttribute("value", session.getAttribute("username"));
                request.setAttribute("value2", session.getAttribute("property"));


                response.sendRedirect("/seller2ndVerification.jsp");
            }else if (error==3){//admin acc

                session.setAttribute("property","admin");

                //set setAttributes of admin's page
                request.setAttribute("value", session.getAttribute("username"));
                request.setAttribute("value2", session.getAttribute("property"));

                session.setAttribute("errorVeri","");
                response.sendRedirect("/admin2ndVerification.jsp");

            }



         //REGISTER BUTTON
        } else if (request.getParameter("reg button") != null) {  // register button pressed





            String username2 = request.getParameter("username2");
            String password2 = request.getParameter("password2");
            String password3 = request.getParameter("password3");

            //REGISTER VALIDATION
            if(username2.isEmpty() || (password2.isEmpty() || password3.isEmpty())) {

                session.setAttribute("RegError", "Please fill all registration fields!"); //Show error
                response.sendRedirect("/index.jsp");



            }else if (!password2.equals(password3)){

                session.setAttribute("RegError", "Please make sure that passwords match"); //Show error
                response.sendRedirect("/index.jsp");


            }else{


                String q2 = request.getParameter("Q2"); //Get radio button parameter

                String radio = request.getParameter("Q2"); //Get radio button condition

                if( radio!=null) { // CHECK IF RADIO BUTTON IS NULL OR NOT

                    //insert new account to database
                    if (infoExist(username2,"username_id",sql)) { // CALL FUNCTION TO CHECK IF USERNAME ALDREADY EXISTS


                        //Insert into database function
                        insertAccount(request.getParameter("username2"),request.getParameter("password2"),request.getParameter("Q2"));


                        //Create session
                        session.setAttribute("property",q2);

                        session.setAttribute("username",username2);


                        //RADIO BUTTONS SELECTION FOR REDIRECTION

                        if ("client".equals(q2)) { //CLIENT

                            // client page
                            response.sendRedirect("/finalStepClient.jsp");

                        } else if ("seller".equals(q2)) { //SELLER

                            response.sendRedirect("/seller2ndVerification.jsp");

                        } else if ("admin".equals(q2)) { //ADMIN

                            session.setAttribute("errorVeri","");
                            request.setAttribute("value", request.getParameter("username2"));
                            response.sendRedirect("/admin2ndVerification.jsp");



                        }


                    } else { //USERNAME ALREADY EXISTS

                        session.setAttribute("RegError", "Username already exists!"); //Show error
                        response.sendRedirect("/index.jsp");

                    }
                }else{

                    session.setAttribute("RegError", "Please choose a property"); //Show error
                    response.sendRedirect("/index.jsp");


                }

            }

        }


    }


    //Check if the username and the password exist and return a property or an error
        public int loginCheck(String username, String password){
        int x=1;

        if(username.isEmpty() || password.isEmpty() ){
            x=1;
        }



        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele","root","password1234!@#");
            Statement myStmt = myConn.createStatement();
            String sql = "select * from mobiletele.users_acc";
            ResultSet rs = myStmt.executeQuery(sql);


            //CHECK THE USERNAME WITH THE EXACT PASSWORD
            while (rs.next()){

                if(rs.getString("username_id").equals(username)) { // Account username found


                    if(rs.getString("hash").equals(encrypt.getHashMD5(password,rs.getString("minerals")))){ //USER GAVE CORRECT PASSWORD


                        if(rs.getString("property").equals("client")){// its a bird
                            x=0;
                        }else if(rs.getString("property").equals("seller")){ // its a plane
                            x=2;
                        }else if(rs.getString("property").equals("admin")){ // NOOO! ITS SUPERMAN!!
                            x=3;
                        }

                        break; //Stop while


                    }else{// if user gave incorrect password stop searching in database

                        x=1;
                        break; //Stop while
                    }

                }else{ //Wrong credentials
                    x=1;

                }

            }

        } catch (SQLException e){ //if sql connection fail

            e.printStackTrace();
        }


        return x;
    }






    // CHECK IF USERNAME ALREADY EXISTS
    public boolean infoExist(String info, String column, String sql){


        boolean x = true;

        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele","root","password1234!@#");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery(sql);


            //CHECK THE USERNAME WITH THE EXACT PASSWORD EXISTS
            while (rs.next()){


                if(rs.getString(column).equals(info) ) {


                    x = false;
                    break; //stop while

                }
            }

            myConn.close();
        } catch (SQLException e){ //if sql connection fail

            e.printStackTrace();
        }

        return x;
    }







    public void insertAccount(String userName, String password, String prop){


        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele", "root", "password1234!@#");

            // INSERT IN DATABASE
            String query = " insert into users_acc (username_id,hash,minerals,property)"
                    + " values (?,?,?,?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1, userName);


            //Convert byte[] to String
            String mineral = Base64.getEncoder().encodeToString(encrypt.createMineral());

            preparedStmt.setString(2, encrypt.getHashMD5(password,mineral));
            preparedStmt.setString(3, mineral);
            preparedStmt.setString(4, prop);


            // execute the prepared statement
            preparedStmt.execute();

            myConn.close();


        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }


}