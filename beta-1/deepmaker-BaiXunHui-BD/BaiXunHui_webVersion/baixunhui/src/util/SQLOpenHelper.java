package util;

import java.sql.*;

public class SQLOpenHelper {
	
	private Connection connection;
	
	public SQLOpenHelper(){
	}
	
	public void databaseOpen() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = java.sql.DriverManager.getConnection
("jdbc:mysql://localhost/baixunhui?characterEncoding=gbk","root","2256504");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void databaseClose(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	
	

}
