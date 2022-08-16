package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException {
		
		try {
			PrintWriter out = resp.getWriter();
			
			String url = "jdbc:mysql://localhost:3306/mbabane";
			String user = "root";
			String pass = "";
			String dbUser = null;
			String dbPassword = null;
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			String query = "select username,password from register where username=? and password=?";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = ((java.sql.Connection) conn).prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				dbUser = rs.getString("username");
				dbPassword = rs.getString("password");
			}
			HttpSession session = req.getSession();
			if(password.equals(dbPassword)) {
				session.setAttribute("username", username);
			}
			if(username.equals(dbUser)&password.equals(dbPassword)) {
				RequestDispatcher rd= req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
				//out.println("You Have Successfully Loged in !"+username);
			}else {
				//resp.sendRedirect("login.jsp");
				out.println("Something Wrong.? please try again.");
				RequestDispatcher rd = req.getRequestDispatcher("user_login.jsp");
				rd.forward(req, resp);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
