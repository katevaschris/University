package properties;

import BasicClass.ConnectToAcc;
import Services.Search_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.script.ScriptContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="properties.Client",urlPatterns={"/properties.Client"})
public class Client extends HttpServlet{

    Search_info search = new Search_info();




    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter writer = response.getWriter();


        // log in button pressed
        if (request.getParameter("create_acc") != null) {

            String f_name = request.getParameter("fname");
            String l_name = request.getParameter("lname");
            String afm = request.getParameter("afm");
            String p_number = request.getParameter("pnumber");


            //check for empty fields
            if(f_name.isEmpty() || l_name.isEmpty() || afm.isEmpty()  || p_number.isEmpty()) {

                writer.println("Please fill all the fields!!"); //Show error

            }else {



                if(!(numberChecker(afm))){// AFM VALIDATION
                    writer.println("Wrong afm, please insert an afm code with 10 numbers!"); //Show error

                }  else if(!(numberChecker(p_number))){ //PHONE NUMBER VALIDATION
                    writer.println("Wrong phone number, please insert a phone number with 10 numbers!"); //Show error


                }else {// INSERT CLIENT INFO

                    //set setAttributes of client's page
                    request.setAttribute("value", session.getAttribute("username"));
                    request.setAttribute("value2", session.getAttribute("property"));

                    response.sendRedirect("/client_page.jsp");


                    //CALL INSERT FUNCTION
                    insertClient(session.getAttribute("username").toString(),f_name,l_name,afm,p_number);

                }

            }
        //LOGOUT BUTTON
        }else if(request.getParameter("logout") != null){
            session.invalidate();

            response.sendRedirect("/index.jsp");


        //PAY BILL
        }else if (request.getParameter("payBill") != null){

            String existOrPaid = alreadyPaid(search.searchInfo(session.getAttribute("username").toString(),"select * from mobiletele.client_info","AFM"),"afm_code");
            //check if client has a program (and can pay bill)
            if(existOrPaid.equals("You do not have a program yet!")) {

                session.setAttribute("paid","You do not have a program yet!");

            }else if(existOrPaid.equals("Bill is already paid or not created yet!")){

                session.setAttribute("paid","Bill is already paid or not created yet!");

            }else{


                if(payBill(search.searchInfo(session.getAttribute("username").toString(),"select * from mobiletele.client_info","AFM"))){


                    session.setAttribute("paid","Bill was paid with success!");


                }else{

                    session.setAttribute("paid","Something went wrong, please try again later");

                }

            }

            response.sendRedirect("client_page.jsp");


         //SHOW CALL HISTORY
        }else if(request.getParameter("callHisory") != null){

            try {

                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");
                Statement myStmt = myConn.createStatement();
                String sql = "select * from call_history";
                ResultSet rs = myStmt.executeQuery(sql);


                //Display users info

                writer.println("CALL HISTORY");
                writer.println("");

                boolean emptyOfCall=true;
                while (rs.next()) {

                    if(rs.getString("afm_code").equals(search.searchInfo(session.getAttribute("username").toString(),"select * from mobiletele.client_info","AFM"))){

                        //Display values

                        writer.println("Number1: " + rs.getString("num1"));
                        writer.println("Number2: " + rs.getString("num2"));
                        writer.println("Number3: " + rs.getString("num3"));
                        writer.println("Number4: " + rs.getString("num4"));
                        writer.println("Number5: " + rs.getString("num5"));

                        emptyOfCall=false;

                    }
                }

                //if client does not have calls (and not a program)
                if(emptyOfCall){
                    writer.println("You do not have calls yet");
                }

                // Clean-up environment
                myConn.close();

            } catch (SQLException e) { //if sql connection fail

                e.printStackTrace();
            }



         //SHOW BILL
        }else if(request.getParameter("showBill") != null){
            String paketo="";
            String billAmount="";

            try {

                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");
                Statement myStmt = myConn.createStatement();
                String sql = "select * from call_history";
                ResultSet rs = myStmt.executeQuery(sql);


                //Display users info

                writer.println("Bill information");
                writer.println("");

                boolean emptyOfCall=true;

                while (rs.next()) {


                    if(rs.getString("afm_code").equals(search.searchInfo(session.getAttribute("username").toString(),"select * from mobiletele.client_info","AFM"))){


                        String a = rs.getString("num1");
                        String a2 = rs.getString("num2");
                        String a3 = rs.getString("num3");
                        String a4 = rs.getString("num4");
                        String a5 = rs.getString("num5");

                                        //GET PACKAGE NAME AND BILL AMOUNT BY SEARCHING IN clients_programs
                                        try {
                                            Statement myStmt2 = myConn.createStatement();
                                            String sql2 = "select * from mobiletele.clients_programs";
                                            ResultSet rs2 = myStmt.executeQuery(sql2);

                                            while (rs2.next()) {
                                                if (rs2.getString("afm_code").equals(search.searchInfo(session.getAttribute("username").toString(),"select * from mobiletele.client_info","AFM"))) {

                                                    paketo = rs2.getString("prog_name");

                                                    //create a string for bill amount to print later
                                                    if(rs2.getString("summary").equals("")){

                                                        billAmount = "Your bill is already paid or not created yet";

                                                    }else{
                                                        billAmount = "The amount of the bill is : " + rs2.getString("summary");
                                                    }



                                                }
                                            }


                                            // Clean-up environment
                                            rs2.close();
                                            myStmt2.close();

                                        } catch (SQLException e) { //if sql connection fail

                                            e.printStackTrace();
                                        }



                                        try {
                                            Statement myStmt2 = myConn.createStatement();
                                            String sql2 = "select * from mobiletele.programs";
                                            ResultSet rs2 = myStmt.executeQuery(sql2);

                                            while (rs2.next()) {
                                                if (rs2.getString("prog_name").equals(paketo)) {
                                                    //DISPLAY PROGRAM INFO

                                                    writer.println("Program name: " + rs2.getString("prog_name"));
                                                    writer.println("Charge per minute in our communication network: " + rs2.getString("inTalk"));
                                                    writer.println("Charge per minute out of our communication network: " + rs2.getString("outTalk"));
                                                    writer.println("Cost per month: " + rs2.getString("costPermonth"));
                                                    writer.println("");
                                                    writer.println("CALL HISTORY:");
                                                    writer.println("Number1: " +a );
                                                    writer.println("Number2: " + a2);
                                                    writer.println("Number3: " + a3);
                                                    writer.println("Number4: " + a4);
                                                    writer.println("Number5: " + a5);
                                                    writer.println("");
                                                    writer.println("");
                                                    writer.println(billAmount);

                                                    //DISPLAY AMOUNT OF BILL





                                                }
                                            }


                                            // Clean-up environment
                                            rs2.close();
                                            myStmt2.close();

                                        } catch (SQLException e) { //if sql connection fail

                                            e.printStackTrace();
                                        }




                        emptyOfCall=false;

                    }
                }

                //if client does not have calls (and not a program)
                if(emptyOfCall){
                    writer.println("You do not have a program yet");
                }

                // Clean-up environment
                myConn.close();

            } catch (SQLException e) { //if sql connection fail

                e.printStackTrace();
            }

            //get afm code and show summary and get progname to display after and display call history in the end
            //mporw na kalesw polles methods me writes kai na na peintarei ola mazi? AN NAI tote to kanw.. AN OXI tote prepei na ta kanw ola mazi mesa sto display calls
        }

    }





    //check if client has a program or if its paid
    public String alreadyPaid(String info, String column){


        String existOrPaid="";

        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC","root","password1234!@#");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select * from mobiletele.clients_programs");


            while (rs.next()){
                existOrPaid = "You do not have a program yet!";

                //check if client has a program
                if(rs.getString(column).equals(info) ) {


                    //check if summary is zero
                    if(rs.getString("summary").equals("")){
                        existOrPaid ="Bill is already paid or not created yet!";

                        System.out.println("sala");
                                break;
                    }

                    break; //stop while

                }
            }

            myConn.close();
        } catch (SQLException e){ //if sql connection fail

            e.printStackTrace();
        }

        return existOrPaid;
    }




    //GENERATE 5 NUMBER NUMBER FOR A CLIENT (function is called whenever a program is given to the client)
    protected void giveCallHistory(String afm){
        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

            // INSERT IN DATABASE
            String query = " insert into call_history (afm_code,num1,num2,num3,num4,num5)"
                    + " values (?,?,?,?,?,?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString(1,afm);
            preparedStmt.setString(2, String.valueOf((long) Math.floor(Math.random() * 6_900_000_000L) + 6_900_000_000L));
            preparedStmt.setString(3, String.valueOf((long) Math.floor(Math.random() * 6_900_000_000L) + 6_900_000_000L));
            preparedStmt.setString(4, String.valueOf((long) Math.floor(Math.random() * 6_900_000_000L) + 6_900_000_000L));
            preparedStmt.setString(5, String.valueOf((long) Math.floor(Math.random() * 6_900_000_000L) + 6_900_000_000L));
            preparedStmt.setString(6, String.valueOf((long) Math.floor(Math.random() * 6_900_000_000L) + 6_900_000_000L));


            // execute the prepared statement
            preparedStmt.execute();

            myConn.close();

            // response.sendRedirect("/sellerActions.jsp");// go to seller account

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    protected int insertClient(String user_id ,String fname, String Lname, String afm , String pnumber){

        int who=0; //to know if i get Exception or not and then redirect to a specific jsp page

        try
        {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC","root","password1234!@#");

            // the mysql insert statement
            String query = " insert into client_info(username_id,First_name,Last_name,AFM,PhoneNumber)"
                    + " values (?,?,?,?,?)";


            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setString (1, user_id);
            preparedStmt.setString   (2, fname);
            preparedStmt.setString (3, Lname);
            preparedStmt.setString   (4, afm);
            preparedStmt.setString (5, pnumber);

            // execute the prepared statement
            preparedStmt.execute();

            myConn.close();

             who=1;

        } catch (Exception e)
        {

            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


        return who;
    }





    protected boolean payBill(String afm){
        boolean error= false;

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele?useTimezone=true&serverTimezone=UTC", "root", "password1234!@#");

            // create the java mysql update preparedstatement
            String query = "update clients_programs set summary = ? where afm_code = ?";
            PreparedStatement preparedStmt = myConn.prepareStatement(query);




            preparedStmt.setString(1,""); // summary is now empty (zero)
            preparedStmt.setString(2,afm); //afm


            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            myConn.close();
            error=true;

        } catch (SQLException e){ //if sql connection fail

            e.printStackTrace();
        }



        return error;
        }




    //AFM AND PHONE NUMBER VALIDATION
    protected boolean numberChecker(String num){
        boolean i=false;

        if((num.matches("[0-9]+") && num.length() == 10)) { //AFM OR PHONE NUMBER ARE WRONG

            i=true;

        }

        return i;
    }

    protected boolean numberChecker2(String num){
        boolean i=false;

        if((num.matches("[0-9]+") && num.length() >= 1)) { //AFM OR PHONE NUMBER ARE WRONG

            i=true;

        }

        return i;
    }


}
