package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import constructor.Product;

public class SqlConnection {

	public static Map<String, String> getUserPass() throws ClassNotFoundException {
		
	Map<String, String> userPassMap = new HashMap<String, String>();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);
		
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "SELECT username, password FROM users";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			userPassMap.put(rs.getString("username"), rs.getString("password"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return userPassMap;
	}
	
	public static Map<Integer, Product> getWkeyboard() throws ClassNotFoundException {
		
	Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);
			
			Statement st = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM products WHERE category_ID = ' 1 '";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
			
			int productID = rs.getInt("product_ID");
			String name = rs.getString("name");	
			String description = rs.getString("description");
			Double price = rs.getDouble("price");
			
			Product product = new Product(name, description, price);
			
			productsMap.put(productID, product);
				
//			Product product = new Product(rs.getString("name"), rs.getString("description"), rs.getDouble("price"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsMap;
		
	}
	
	public static Map<Integer, Product> getCkeyboard() throws ClassNotFoundException {
		
	Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);
			
			Statement st = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM products WHERE category_ID = ' 3 '";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
			
			int productID = rs.getInt("product_ID");	
			String name = rs.getString("name");	
			String description = rs.getString("description");
			Double price = rs.getDouble("price");
			
			Product product = new Product(name, description, price);
			
			productsMap.put(productID, product);
				
//			Product product = new Product(rs.getString("name"), rs.getString("description"), rs.getDouble("price"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsMap;
		
	}
	
	
	public static Map<Integer, Product> getCmouse() throws ClassNotFoundException {
		
	Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);
			
			Statement st = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM products WHERE category_ID = ' 4 '";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
			
			int productID = rs.getInt("product_ID");	
			String name = rs.getString("name");	
			String description = rs.getString("description");
			Double price = rs.getDouble("price");
			
			Product product = new Product(name, description, price);
			
			productsMap.put(productID, product);
				
//			Product product = new Product(rs.getString("name"), rs.getString("description"), rs.getDouble("price"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsMap;
		
	}
	
	
	public static Map<Integer, Product> getWmouse() throws ClassNotFoundException {
		
	Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);
			
			Statement st = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM products WHERE category_ID = ' 2 '";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
			
			int productID = rs.getInt("product_ID");	
			String name = rs.getString("name");	
			String description = rs.getString("description");
			Double price = rs.getDouble("price");
			
			Product product = new Product(name, description, price);
			
			productsMap.put(productID, product);
				
//			Product product = new Product(rs.getString("name"), rs.getString("description"), rs.getDouble("price"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsMap;
		
	}
	
	
}
