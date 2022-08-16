
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
                    
	body {
		background-image: url('company.jpg');
		background-size: cover;
		font-family: Montserrat;
	}
                    
			#regform{
			text-align:justify;
			padding:15px 15px;
			background-color:darkgoldenrod;
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

<jsp:include page="userForm.html"></jsp:include>

</body>
</html>
