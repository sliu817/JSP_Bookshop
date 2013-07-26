package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStream;
import java.util.Properties;

public class dbconn {
	
	String driverName=null;
	String connString=null;
	String userName=null;
	String password=null;
	String propertyFileName=null;
	
	public dbconn(){
		
	}
	
	public Connection getDBConn(){
		this.setPropertyFileName("/dbconn.properties");
		driverName=this.getPropertyFromFile("driverName");
		connString=this.getPropertyFromFile("connString");
		userName=this.getPropertyFromFile("userName");
		password=this.getPropertyFromFile("password");
		if(driverName==null||connString==null||userName==null) return null;
		try{
			//Connection connDBObject=null;
			Class.forName(driverName);
			return DriverManager.getConnection(connString,userName,password);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public String getConnString(){
		return connString;
	}
	public String getDriverName(){
		return driverName;
	}	
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPropertyFileName(String propertyFileName){
		this.propertyFileName = propertyFileName;
	}
	public String getPropertyFileName(){
		return propertyFileName;
	}
	public String getPropertyFromFile(String refName){
		if(this.getPropertyFileName()==null) return new String("");
		try{
			InputStream fin = getClass().getResourceAsStream(this.getPropertyFileName());
			Properties props = new Properties();
			props.load(fin);
			return (String)props.getProperty(refName);
		}catch(Exception e){
			e.printStackTrace();
			return new String("");
		}
	}

}
