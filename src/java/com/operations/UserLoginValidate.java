package com.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.Dbconnection;
import com.pojo.UserPojo;
import java.sql.SQLException;

public class UserLoginValidate {
	public static List<UserPojo> getUsers(int id,String password){		
		List<UserPojo>list = new ArrayList<>();
		//take a list to store the values which are in db
		 try{  
			Connection con=Dbconnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from reginfo where id=? and password=?");  
			ps.setInt(1,id);  
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  				
				UserPojo pObject=new UserPojo(); 
				pObject.setId(rs.getInt(1));  
				pObject.setUsername(rs.getString(2)); //if the values exist in db then											
				pObject.setPass(rs.getString(3));     // set them to setters and getters and them to list and return the list finally
				pObject.setEmail(rs.getString(4));
				list.add(pObject);
			}  
			con.close();  
		}catch(SQLException ex){}  		  
		return list;  //returns the list		
	}
}
