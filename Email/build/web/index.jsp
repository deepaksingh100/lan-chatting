<%-- 
    Document   : index
    Created on : 10 Feb, 2015, 1:40:28 PM
    Author     : SONY
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EmailId Verification</title>
    </head>
    <body>
        <%String n="";
            String temp=request.getParameter("tempid");
            String em=request.getParameter("email");
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "system","system");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select tempid from chat where emailid='"+em+"'");
            if(rs.next())
                n=rs.getString("tempid");
            if(n.equals(temp)){
                st.executeUpdate("update chat set verifystatus='Y' where emailid='"+em +"'");
            %>
            <h2>Congratulations!!!</h2>
        <p>Your EmailId had been Verified!!!<br>Now You are ready to use MY CHAT APP!!!</p>
        <%
            }
               else{
        %>
               <h2>Unsuccessfull!!!</h2>
        <p>Your EmailId had not been Verified!!!</p>
        <%
            }
            
            }catch(Exception e){System.out.println(e);
            }
        %>
        
    </body>
</html>
