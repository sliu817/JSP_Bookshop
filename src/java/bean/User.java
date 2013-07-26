package bean;

public class User {
	private final int COMMON_USER = 1;
	private final int ADMIN_USER = 2;
	
	private int userID;
	private String userName;
	private String userTrueName;
	private String address;
	private String telephone;
	private String postalCode;
	private int userRole;
	private String password;
	
	public User(){
	
		this.userName = "";
		this.userTrueName = "";
		this.address = "";
		this.telephone = "";
		this.postalCode = "";
		this.userRole = 1;
		this.password = "";
	}	
	
	public User(String username,String password){
		
		this.userName = username;
		this.userTrueName = "";
		this.address = "";
		this.telephone = "";
		this.postalCode = "";
		this.userRole = 1;
		this.password = password;
	}	
	
	public User(String userName,String password,String userTrueName,String address,
			String telephone,String postalCode ){		
		
		this.userName = userName;
		this.password = password;
		this.userTrueName = userTrueName;
		this.address = address;
		this.telephone = telephone;
		this.postalCode = postalCode;		
	}
	
	public int getUserID(){
		return userID;
	}

	public String getUserName(){
		return userName;
	}
	
	public String getUserTrueName(){
		return userTrueName;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getTelephone(){
		return telephone;
	}
	
	public String getPostalCode(){
		return postalCode;
	}
	
	public int getUserRole(){
		return userRole;
	}
	
	public String getPassword(){
		return password;
	}
	
	
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public void setUserTrueName(String userTrueName){
		this.userTrueName = userTrueName;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public void setUserRole(int userRole){
		if(userRole == ADMIN_USER)
			this.userRole = ADMIN_USER;
		else
			this.userRole = COMMON_USER;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
}
