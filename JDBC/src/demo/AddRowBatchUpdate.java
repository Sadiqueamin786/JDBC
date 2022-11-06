package demo;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class AddRowBatchUpdate {

		public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub
				String url="jdbc:oracle:thin:@//localhost:1522/XE";
				String un="system";
				String pwd="system";
				Connection con=null;
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				con=DriverManager.getConnection(url, un, pwd);
				//DriverManager.registerDriver(new OracleDriver());
				//Statement stmt=null;
				//ResultSet res=null;
				//PreparedStatement pstmt=null;
				//Statement stmt = con.createStatement();
				System.out.println("succesful");
				
				//System.out.println("succesfull");
				
				String query="insert into STUDENTDETAILS values(?,?,?,?,?)";
				PreparedStatement  pstmt=con.prepareStatement(query);
				
				con.setAutoCommit(false);
				for(int i=0; i<3; i++)
				{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Name");
				String temp1=s.nextLine();
				
				
				System.out.println("Enter id");
				String temp2=s.nextLine();
				
				
				System.out.println("Enter Marks1");
				int temp3=s.nextInt();
				
				
				System.out.println("Enter Marks2");
				int temp4=s.nextInt();
				
				
				System.out.println("Enter Marks3");
				int temp5=s.nextInt();
				
				pstmt.setString(1, temp1);
				pstmt.setString(2, temp2);
				pstmt.setInt(3, temp3);
				pstmt.setInt(4, temp4);
				pstmt.setInt(5, temp5);
				
				pstmt.executeUpdate();
				}
				con.commit();



	}

}
