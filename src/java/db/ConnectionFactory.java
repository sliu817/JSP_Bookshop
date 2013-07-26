package db;

import java.io.File;
import java.sql.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConnectionFactory {
	
	static	String driver = "";
	static	String url = "";
	static	String username = "";
	static	String password = "";		
	
	private static ConnectionFactory ref=new ConnectionFactory();
	private static Connection con;	
	
	
	private ConnectionFactory(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("ERROR:"+e);
		}
	}	
	
	public static Connection getConnection()throws SQLException{
		String url="jdbc:mysql://localhost:3306/bookstore";
		return con=DriverManager.getConnection(url,"root","123");
	}
	
        /*private ConnectionFactory(){
		File file = new File("../webapps/BookStore/WEB-INF/connection.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			NodeList nl = doc.getElementsByTagName("connection");
			for(int i=0; i<nl.getLength(); i++){
				Element node = (Element)nl.item(i);
				//System.out.println(node.getNodeName());
				NodeList driver_nl = node.getElementsByTagName("driver");
				driver = driver_nl.item(0).getFirstChild().getNodeValue().trim();
				System.out.println(driver);
				NodeList url_nl = node.getElementsByTagName("url");
				url = url_nl.item(0).getFirstChild().getNodeValue().trim();				
				//System.out.println(url);
				NodeList username_nl = node.getElementsByTagName("username");
				username = username_nl.item(0).getFirstChild().getNodeValue().trim();
				
				NodeList password_nl = node.getElementsByTagName("password");
				password = password_nl.item(0).getFirstChild().getNodeValue().trim();
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			System.out.println("ERROR:"+e);
		}
	}
	/**
	 * ͨ��XML������
	
	public static Connection getConnection()throws SQLException{
		if(con==null||con.isClosed())
			con=DriverManager.getConnection(url,username,password);
		return con;
	} */
	
	public static void close(ResultSet rs){
		try{
			//if(!rs.isClosed())
				rs.close();
		}catch(Exception ignored){}
	}
	
	public static void close(Statement st){
		try{
			//if(!st.isClosed())
				st.close();
		}catch(Exception ignored){}
	}

	public static void close(Connection cn){
		try{
			//if(!cn.isClosed())
				cn.close();
		}catch(Exception ignored){}
	}
	
	public static void close(PreparedStatement ps){
		try{
			ps.close();
		}catch(Exception ignored){}
	}
	
	
	public static void main(String[] args){
		
		try {
			ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO �
			e.printStackTrace();
		}
	}
}
