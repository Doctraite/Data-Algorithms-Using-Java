<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mbabane Municipality Transport System</title>
		<style>
                    
                    body {
                          background-image: url('company.jpg');
                          background-size: cover;
                          font-family: Montserrat;
                   }
                    
		#loginform{
			text-align:justify;
			padding:15px 15px;
			background-color:green;
			height:200px;
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
		<h1>Forgot Password</h1>
                <form action="SendEmail_1.jsp" method="post">
			<table id="loginform" cellspacing="20" align="center">
			<tr>
                            <td>Enter email :</td><br>
                            <td>
                                <input type="text" id="id" name="userid" placeholder="Enter email" required="required">
                            </td>
                        </tr>
			
                        <tr><td colspan=5 align="center"><button type="submit" id="login">SEND</button></td></tr>
                        <tr>
                            <td colspan=5 align="center">
                                <a href="Login.jsp" class="btn btn-block">Back to Login</a>
                            </td>
                        </tr></table>
		</form>
	</body>
</html>


