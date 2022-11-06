package demo;

import java.sql.*;
import java.util.Scanner;

public class FetchingData {

	public static void main(String[] args) throws Exception {
		String url="jdbc:oracle:thin:@//localhost:1522/XE";
		String un="system";
		String pwd="system";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		
		con=DriverManager.getConnection(url,un,pwd);
		System.out.println("Connection succesfull");
		
		String query="SELECT * FROM STUDENTDETAILS WHERE NAME=?";
		pstmt=con.prepareStatement(query);
		System.out.println("PlateForm Created:");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The NAME");
		String name=sc.nextLine();
		sc.close();
		pstmt.setString(1,name);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			String id=rs.getString(2);
			int marks1=rs.getInt(3);
			int marks2=rs.getInt(4);
			int marks3=rs.getInt(5);
			System.out.println(name+" " + id + " " + marks1 + " " + marks2 + " " + marks3 );
		}
		else
		{
			System.out.println("No Data Found "+name);
		}
		
	}

}
