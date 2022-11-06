package demo;

import java.sql.*;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) throws Exception {
		String url="jdbc:oracle:thin:@//localhost:1522/XE";
		String un="system";
		String pwd="system";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded ");
		
		con=DriverManager.getConnection(url,un,pwd);
		System.out.println("Connection Established");
		
		String query="insert into LOGIN values(?,?,?,?) ";
		pstmt=con.prepareStatement(query);
		
		Scanner sc=new Scanner(System.in);
		
		
		
		System.out.println("Enter The Name :");
		String Name=sc.nextLine();
		
		System.out.println("Enter The user Name :");
		String Un=sc.nextLine();
		
		System.out.println("Enter the Password : ");
		int password=sc.nextInt();
		
		System.out.println("Enter Serial Number");
		int sn=sc.nextInt();
		
		
		pstmt.setString(2, Name);
		pstmt.setString(3, Un);
		pstmt.setInt(4, password);
		pstmt.setInt(1, sn);
		
		pstmt.executeQuery();
		
		con.commit();
		System.out.println("Data Inserted Succesfully:");
	}

}
