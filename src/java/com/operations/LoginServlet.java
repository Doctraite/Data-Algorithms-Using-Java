package com.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.UserPojo;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		try{
			String uid=req.getParameter("userid");
			int id=Integer.parseInt(uid); //getting userid and password from user 
			String password =req.getParameter("password");	
			UserPojo pObject = new UserPojo();
			pObject.setId(id);  //setting them to setters and getters
			pObject.setPass(password);
			List<UserPojo>list = new ArrayList<>(); //take a list
			  list =UserLoginValidate.getUsers(id, password); //send the values id and password to vadlidate class of getUsers method and storing the resultset in list
			 if(!(list.isEmpty())){
				 //if list has some values then you are logged in
			 out.print("<h1 align='center'>Congrats!You've SuccessFully Logged In</h1>");
				 out.print("<table align ='center' border='1' cellspacing='5' cellpadding='5'>"
                                         + "<tr><"
                                         + "th>ID</th>"
                                         + "<th>NAME</th>"
                                         + "<th>Password</th>"
                                         + "<th>Email</th>"
                                         + "</tr>");
			    for(UserPojo i:list){	 	 
			    	//printing all the values in the list
			         out.print("<tr><td>" +i.getId()+ "</td>");
			         out.print("<td>" +i.getUsername()+ "</td>");
			         out.print("<td>" +i.getPass()+ "</td>");
			         out.print("<td>" +i.getEmail()+"</td></tr>");
			    }
		out.print("</table>");
		
			 }else{
		            req.getRequestDispatcher("Login.jsp").include(req, resp);
		            out.print("<p align='center'>User Does Not Exist! Please Register");
			         out.print("<a href='first_index.jsp'>Register Here</a></p>");
			 }
		}catch(Exception e){
            req.getRequestDispatcher("Login.jsp").include(req, resp);
            out.print("<p>Please Enter Valid Details To Login</p>");
		
		}
	}
}
