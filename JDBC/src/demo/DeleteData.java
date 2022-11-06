package demo;

import java.sql.*;

public class DeleteData {

	
	public static void main(String[ ] args)
	{ 
	String url="jdbc:oracle:thin:@//localhost:1522/XE";
	String un="system";
	String pwd="system";
	
	Connection con = null; 
	Statement stmt = null;
	String qry= " delete from STUDENTDETAILSt where id=BJS1"; 
	try {
	Class.forName("com.oracle.jdbc.Driver"); 
	System.out.println("Driver class loaded and register ");
	 con=DriverManager.getConnection(url,un,pwd); 
	System.out.println("Connection Established");
	stmt = con.createStatement();
	System.out.println("Platform created"); 
	stmt.executeUpdate(qry); 
	System.out.println("Data Deleted");
	}
	catch (ClassNotFoundException | SQLException e) 
	{ e.printStackTrace();
	} 
	finally {
	if (stmt!= null) {
	try {
	stmt.close();
	} catch (SQLException e) 
	{
	 e.printStackTrace();
	} }
	if(con!=null) {
		
	try {
	con.close();
	} catch (SQLException e)
	{
	 e.printStackTrace();
	 
			}
	
		}
	
	} 
	
	}

}
