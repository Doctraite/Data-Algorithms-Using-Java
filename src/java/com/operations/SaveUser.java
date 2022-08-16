package com.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.dbconnection.Dbconnection;
import com.pojo.UserPojo;

public class SaveUser {
	public static int save(UserPojo pObject){
		int flag=0;
		try {
			Connection con=Dbconnection.getConnection(); //getting the connection method here from dbconnection
			PreparedStatement ps = con.prepareStatement("insert into reginfo values(?,?,?,?);");
			ps.setInt(1, pObject.getId());
			ps.setString(2, pObject.getUsername());//sending up the values received from user to the database table
			ps.setString(3, pObject.getPass());
			ps.setString(4, pObject.getEmail());
			flag=ps.executeUpdate(); //value changes if it is executed
			con.close();
		} catch (Exception e) {
		System.out.println(e);
		}
		return flag; // returns greater than zero if inserted into database
	}	
}
