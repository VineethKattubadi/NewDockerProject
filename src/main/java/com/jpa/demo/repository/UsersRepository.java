package com.jpa.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.jpa.demo.dto.Users;

@Repository
public class UsersRepository {
public boolean authenticate(Users u) {
	int count = 0;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs= null;
	String url ="jdbc:postgresql://localhost:5432/awsdb";
	try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url,"postgres","root");
		pst = con.prepareStatement("select count(*) from users where username=? and password=?");
		pst.setString(1, u.getUsername());
		pst.setString(2,u.getPassword());
		rs = pst.executeQuery();
				if(rs.next())
			count =rs.getInt(1);
		rs.close();
		pst.close();
		con.close();
		
		
	}catch(Exception ex) {
		ex.getStackTrace();
	}
	
	
	return count== 1;
}
public boolean addUser(Users u) {
	int count = 0;
	Connection con = null;
	PreparedStatement pst = null;
	//ResultSet rs= null;
	String url ="jdbc:postgresql://localhost:5432/awsdb";
	try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url,"postgres","root");
		pst = con.prepareStatement("insert into users values(?,?)");
		pst.setString(1, u.getUsername());
		pst.setString(2,u.getPassword());
		count = pst.executeUpdate();
//		if(rs.next())
//			count =rs.getInt(1);
//		rs.close();
		pst.close();
		con.close();
		
		
	}catch(Exception ex) {
		ex.getStackTrace();
	}
	
	
	return count== 1;
	
}
}
