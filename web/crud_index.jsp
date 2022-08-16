<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mbabane Municipality Transport System</title>
        <style>
                    
                     body {
                            background-image: url('company.jpg');
                            background-size: cover;
                            font-family: Montserrat;
                         }
                    
			#regform{
			text-align:justify;
			padding:15px 15px;
			background-color:green;
			height:400px;
			border-radius:15px;
			}
			td{
			width:100px;
			color:white;
			}
			p{

			text-align:center;
			font-size:16pt;
			color:white;
			}
			h1{
			margin:10px;
			text-align:center;
			background-color:darkgoldenrod;
			color:#fff;
			}
		</style>
    </head>
    <body>
        <%@ include file="header.html" %>  <br>
    <center>
        <a href="adduserForm.jsp">Add User</a>
        <a href="viewUsers.jsp">View Users</a>
    </center>
    </body>
</html>
