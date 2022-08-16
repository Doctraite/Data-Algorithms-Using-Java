package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class home extends HttpServlet {

public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException {
		
		try {
			PrintWriter out = resp.getWriter();
			
			String url = "jdbc:mysql://localhost:3306/mbabane";
			String user = "root";
			String pass = "";
			String query = "select * from register";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = ((java.sql.Connection) conn).prepareStatement(query);
			ResultSet rs = ps.executeQuery();
		
			out.println("<html>"
                                + "<body>"
                                + "<table>"
                                + "<tr>"
                                + "<td>ID</td>"
                                + "<td>USERNAME</td>"
                                + "<td>EMAIL</td>"
                                + "<td>MOBILE NO.</td>"
                                + "</tr>");
			
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
			
			out.println("</table></body></html>");
			
		}	catch (Exception e) {
				// TODO: handle exception
			}
	}
}
