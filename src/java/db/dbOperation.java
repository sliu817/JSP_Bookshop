package db;

import java.util.*;
import java.sql.*;

import bean.BookBean;
import bean.User;

public class dbOperation {
	//
	public static ArrayList getBooks() throws SQLException{
		ArrayList list=new ArrayList();
		BookBean book = null;
		
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from booklist");
			
			while(rs.next()){
				book=new BookBean(rs.getLong(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getDouble(5),
									rs.getDouble(6),
									rs.getInt(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10),
									rs.getString(11)
									);
				list.add(book);				
			}			
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);
		
		return list;
	}
			
	//��
	public static ArrayList getBooks(int bookCount){
		ArrayList list=new ArrayList();
		BookBean book = null;
		
		try{
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from booklist where book_id>70");
			int i=0;
			while(rs.next()&&i<bookCount){
				book=new BookBean(rs.getLong(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getDouble(5),
									rs.getDouble(6),
									rs.getInt(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10),
									rs.getString(11)
									);
				list.add(book);				
				i++;
			}			
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);
		}catch(SQLException e){
			System.out.println(e);
		}
		return list;
	}
	
	//�
	public static ArrayList getBooks(String bookName,String author,
			String publisher,String bookType)throws SQLException{
		ArrayList list = new ArrayList();
		BookBean book = null;
		String sqlString = null;
		sqlString = "select * from booklist"+" ";

                //
		/*if(bookName!=null && bookName.trim().length()!=0)
			sqlString += " intersect select * from booklist where book_name like '%"+bookName+"%'";
		if(author!=null && author.trim().length()!=0)
			sqlString += " intersect select * from booklist where author like '%"+author+"%'";
		if(publisher!=null && publisher.trim().length()!=0)
			sqlString += " intersect select * from booklist where publisher like '%"+publisher+"%'";
		if(bookType!=null && bookType.trim().length()!=0)
			sqlString += " intersect select * from booklist where type_id = (" +
					"select type_id from book_type where type_name like '%"+bookType+"%')";
		*/
                if(bookName!=null && bookName.trim().length()!=0) 
                {
                        sqlString += "where book_name like '%"+bookName+"%'";
                }else if(author!=null && author.trim().length()!=0)
                {
                         sqlString += "where author like '%"+author+"%'";
                }else if(publisher!=null && publisher.trim().length()!=0)
                {
                        sqlString += "where publisher like '%"+publisher+"%'";
                }else if(bookType!=null && bookType.trim().length()!=0)
                {
                        sqlString += "where type_id = (" +
				"select type_id from book_type where type_name like '%"+bookType+"%')";
                }
                
		
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlString);
			
			while(rs.next()){
				book=new BookBean(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getDouble(5),
									rs.getDouble(6),
									rs.getInt(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10),
									rs.getString(11)
									);
				list.add(book);				
				
			}			
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);
		
		return list;
	}
	
	//�
	public static BookBean getBookInfo(String bookID) throws SQLException{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
                BookBean book = null;
		String sqlString="select * from booklist where book_id='"+ bookID+"'";

		con = ConnectionFactory.getConnection();
		st = con.createStatement();
		rs = st.executeQuery(sqlString);
                
                while(rs.next()){
				book=new BookBean(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getDouble(5),
									rs.getDouble(6),
									rs.getInt(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10),
                                                                        rs.getString(11)
									);
                }

		return book;
	}
	

	public static boolean registerUserSuccess(String username,String password,
			String userTruename,String address,String telephone,String postalCode){
		boolean flag=true;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try{
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select user_name from netuser where user_name='"+username+"'");
			con.setAutoCommit(false);
			
			while(rs.next()){
				String name=rs.getString(1);
				if(name.equals(username)){
					flag=false;
					break;
				}
			}
			if(flag){
				st.execute("insert into netuser(user_name,user_true_name,user_address,user_telephone,user_postalcode,user_role,user_password)" +
						" values('"+username+"','"
								   +userTruename+"','"
								   +address+"','"
								   +telephone+"','"
								   +postalCode+"',"
								   +1+",'"+password+"'"+
								   ")");
				con.commit();
			}
			
			return flag;
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
				con.rollback();
			}catch(Exception e1){
				
			}
			return flag;
		}finally{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);			
		}				
	}
	

	public static boolean registerUserSuccess(User user){
		boolean flag=true;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		String username=user.getUserName();
		String password=user.getPassword();
		String userTruename=user.getUserTrueName();
		String address=user.getAddress();
		String telephone=user.getTelephone();
		String postalCode=user.getPostalCode();
		
		try{
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select user_name from netuser where user_name='"+username+"'");
			con.setAutoCommit(false);
			
			while(rs.next()){
				String name=rs.getString(1);
				if(name.equals(username)){
					flag=false;
					break;
				}
			}
			if(flag){
				st.execute("insert into netuser(user_name,user_true_name,user_address,user_telephone,user_postalcode,user_role,user_password)" +
						" values('"+username+"','"
						
								   +userTruename+"','"
								   +address+"','"
								   +telephone+"','"
								   +postalCode+"',"
								   +1+",'" +password+"'"+
								   ")");
				con.commit();
			}
			
			return flag;
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
				con.rollback();
			}catch(Exception e1){
				System.out.println(e1);
			}
			return flag;
		}finally{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);			
		}				
	}
	

	public static boolean isUserValidate(String username,String password){
		boolean flag=false;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String tempPassword=null;
		
		try{
			con=ConnectionFactory.getConnection();
                        st=con.createStatement();
                        rs=st.executeQuery("select user_password from netuser where user_name='"+username+"'");
			con.setAutoCommit(false);
			if(rs.next())
				tempPassword=rs.getString(1);
			if(tempPassword!=null &&tempPassword.trim().length()!=0 && tempPassword.equals(password)){
				flag=true;
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);
		}		
		return flag;
	}	

	public static int getUserIDByName(String username){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String sqlString="";
		int userID=0;
		
		try{
			con=ConnectionFactory.getConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			sqlString = "select user_id from netuser where user_name like '"+username+"'";
			rs=st.executeQuery(sqlString);
			rs.next();
			userID=rs.getInt("user_id");
		}catch(Exception e){
			System.out.println(e);
			return userID;
		}finally{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(st);
			ConnectionFactory.close(con);
		}
		return userID;
	}
	
	public static User getUser(String username){

    	Connection con=null;
    	Statement st=null;
    	ResultSet rs=null;
    	String sqlString=null;
    	User user=null;
    	try{
    		con=ConnectionFactory.getConnection();
    		st = con.createStatement();
    		sqlString = "select * from netuser where user_name like '"+username+"'";
    		rs=st.executeQuery(sqlString);
    		rs.next();
    		String password = rs.getString("user_password");
			String userTrueName = rs.getString("user_true_name");
			String address = rs.getString("user_address");
			String telephone = rs.getString("user_telephone");
			String postalCode = rs.getString("user_postalcode");
			user=new User(username,password,userTrueName,address,telephone,postalCode);
    		}catch(SQLException e){
    			System.out.println(e);
    		}    			
		return user;
	}
	
	public static void updateUserInfo(String username,String userTruename,String address,
			String telephone,String postalcode)throws SQLException,Exception{
		Connection con=null;
		PreparedStatement ps=null;
				
		if(username==null)	username="";
		if(address==null)	address="";
		if(telephone==null)telephone="";
		if(postalcode==null)postalcode="";
		
		con=ConnectionFactory.getConnection();
		con.setAutoCommit(false);
		
		ps=con.prepareStatement("update netuser set user_true_name=?,user_address=?,user_telephone=?,user_postalcode=? where user_name=?");
		ps.setString(1, userTruename);
		ps.setString(2, address);
		ps.setString(3, telephone);
		ps.setString(4, postalcode);
		ps.setString(5, username);
		
		ps.executeUpdate();
		con.commit();
		
		ps.close();
		con.close();
	}
	

	public static boolean makeOrder(int userID,Hashtable buyedBooks){
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try{
			con=ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			ps=con.prepareStatement("insert into order_form(user_id) values(?)");
			ps.setInt(1, userID);
			ps.executeUpdate();
			
			int order_id = 0;
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select order_form_id from order_form where user_id='"+userID+"'");
			while(rs.next()){
				order_id = rs.getInt("order_form_id");				
			}
			
			System.out.println(order_id);//
			ps=con.prepareStatement("insert into order_form_book(order_form_id,book_id,book_count) values(?,?,?)");
			Enumeration enume = buyedBooks.keys();
			
			while(enume.hasMoreElements()){
				String bookID=(String)enume.nextElement();				
				int bookCount = ((Integer)buyedBooks.get(bookID)).intValue();
				ps.setInt(1, order_id);
				ps.setString(2, bookID);
				ps.setInt(3, bookCount);
				
				ps.executeUpdate();
			}
			
			con.commit();
			flag=true;
		}catch(Exception e){
			System.out.println(e);
			try{				
				con.rollback();
			}catch(Exception e1){}		
			return flag;
		}finally{
			
			ConnectionFactory.close(ps);
			ConnectionFactory.close(con);
		}
		
		
		return flag;
	}
        
    
	
	public static void main(String[] args)throws Exception{
		/*ArrayList list=dbOperation.getBooks();
		Iterator it=list.listIterator();
		while(it.hasNext()){
			BookBean book=(BookBean)it.next();
			System.out.println(book.getBookName()+" "+
								book.getBookView());
		}*/
		
		//System.out.println(registerUserSuccess("jjj","123","��","�Ϻ���","58370610","201200"));
		//System.out.println(isUserValidate("sun","sa"));
		
		/*ArrayList list=getBooks("","","","С˵");
		Iterator it=list.listIterator();
		while(it.hasNext()){
			BookBean book=(BookBean)it.next();
			System.out.println(book.getBookName());
		}*/
		
		/*System.out.println(getNewOrderNO());
		
		bean.Cart myCart = new bean.Cart();		
		myCart.addBook("70", 1);
		myCart.addBook("73", 2);
		
		Hashtable myBooks = myCart.listMyBooks();
		
		java.sql.Date date;
		java.util.Date d = new java.util.Date();
		date=new Date(d.getYear(),d.getMonth(),d.getDate());
		bean.OrderForm myOrder = new OrderForm(getNewOrderNO(),8,1,myBooks);
		createOrder(myOrder);*/
		
		/*java.sql.Date date;
		java.util.Date d = new java.util.Date();
		date=new java.sql.Date(d.getYear(),d.getMonth(),d.getDate());
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			con=ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String sqlString = "insert into order_form(user_id,add_time,status)";
			sqlString += " values(?,?,?)";
			ps = con.prepareStatement(sqlString);
			ps.setLong(1, 78);		
			//ps.setNull(2, 1);
			ps.setDate(2, date);
			ps.setInt(3, 0);
			ps.executeUpdate();
			
			con.commit();		
			System.out.println("ok");
			
		}catch(Exception e){
			try{
				con.rollback();
			}catch(Exception ee){
				System.out.println(ee);
			}
			System.out.println(e);
		}finally{
			ConnectionFactory.close(ps);
			ConnectionFactory.close(con);
		}
		
		
		System.out.println(getUserIDByName("jjj"));
		//System.out.println(makeOrder(8));
		
		try{
			updateUserInfo("sunny","sunjia","shanghai","65691895","201202");
		}catch(Exception e){
			System.out.println(e);
		}*/
	}

}