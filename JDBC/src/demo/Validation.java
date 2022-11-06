package demo;

import java.sql.*;
import java.util.Scanner;

public class Validation {

	public static void main(String[] args) throws Exception {
		String url="jdbc:oracle:thin:@//localhost:1522/XE";
	    String un="system";
	    String pwd="system";
	    
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    System.out.println("Driver Loaded Succesfully:");
	    
	    con=DriverManager.getConnection(url,un,pwd);
	    System.out.println("Connection Establist:");
	    
	    String query="SELECT * FROM LOGIN WHERE UN=? and password=?";
	    
	    pstmt=con.prepareStatement(query);
	    System.out.println("Plateform created:");
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the User Name :");
	    String UN=sc.nextLine();
	    
	    System.out.println("Enter the Password");
	    int password=sc.nextInt();
	    sc.close();
	    
	    
	    
	    
	    pstmt.setString(1,UN);
	    pstmt.setInt(2, password);
	    
	    rs=pstmt.executeQuery();
	    if(rs.next()) {
	    	String NAME=rs.getString(1);
	    	System.out.println("Welcome " + NAME);
	    }
	    else {
	    	System.out.println("Invalid UserName and password:");
	    }
	}

}
