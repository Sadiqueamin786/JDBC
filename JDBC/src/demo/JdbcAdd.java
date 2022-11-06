package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcAdd {

	public static void main(String[] args) throws Exception  {
		String url="jdbc:oracle:thin:@//localhost:1522/XE";
		//String url="jdbc:oracle:thin:@//localhost:1522/XE";

		String un="system";
		String pwd="system";
		Connection con=null;
		ResultSet res=null;
		Statement pstmt=null;
		
		//Class.forName("oracle.jdbc.driver.oracleDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");

		System.out.println("driver loaded");
		
		con=DriverManager.getConnection(url,un,pwd);
		System.out.println("connection succesfull");
		
		String query="DELETE FROM STUDENTDETAILS WHERE ID='BJS6'";
		String query1="DELETE FROM STUDENTDETAILS WHERE ID='BJS8'";

		pstmt=con.createStatement();
		pstmt.executeUpdate(query);
		pstmt.executeUpdate(query1);

		
		
		System.out.println("delete succesfull:");
	}

}
