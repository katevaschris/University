package Services;

import BasicClass.ConnectToAcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Search_info extends HttpServlet{



    //GET PROPERTY OR AFM CODE  BACK
    public String searchInfo(String username,String db,String getWhat)  {
        String info="";
        try{

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiletele","root","password1234!@#");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery(db);


            //CHECK THE USERNAME WITH THE EXACT PASSWORD EXISTS
            while (rs.next()){


                //find username
                if(rs.getString("username_id").equals(username) ) {


                    //get property or afm
                    info = rs.getString(getWhat);


                    break; //stop while
                }
            }
            myConn.close();
        }catch (SQLException e){ //if sql connection fail

            e.printStackTrace();
        }

        return info;
    }


}
