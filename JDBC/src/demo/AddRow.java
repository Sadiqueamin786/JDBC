package demo;

import java.sql.*;
import java.util.Scanner;

public class AddRow {

	public static void main(String[] args) throws Exception {

		String url="jdbc:oracle:thin:@//localhost:1522/XE";
		String un="system";
		String pw="system";
		Connection con=null;
		ResultSet res=null;
		PreparedStatement pstmt=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection(url, un, pw);
		System.out.println("Succesfull");
		for(int i=0; i<1; i++) {
		String query="INSERT INTO REGISTERUSER VALUES(?,?,?,?,?)";
		pstmt=con.prepareStatement(query);
		System.out.println("abc");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name:");
		String temp1=sc.nextLine();
		
		System.out.println("Enter mail:");
		//String temp2=sc.nextLine();
		String temp2=sc.nextLine();
		System.out.println("Enter pass:");
		//int temp3=sc.nextInt();
		String temp3=sc.nextLine();
		
		System.out.println("Enter country:");
		//int temp4=sc.nextInt();
		String temp4=sc.nextLine();
//		System.out.println("Enter Marks3:");
//		int temp5=sc.nextInt();
		
		pstmt.setString(1, temp1);
		pstmt.setString(2, temp2);
		pstmt.setString(3, temp3);
		pstmt.setString(4, temp4);
		//pstmt.setInt(5, temp5);
		}
		pstmt.executeBatch();
		
		//System.out.println(z);
		con.close();
		pstmt.close();
		
	}

}
