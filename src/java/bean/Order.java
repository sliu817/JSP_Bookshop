package bean;

import java.util.Date;
import java.util.Hashtable;

public class Order {

	private String orderID=null;
	private String userID=null;
	private Date addTime=null;
	private int status=-1;
	private Hashtable books=null;
	
	public Order(String orderID,String userID,Date addTime,int status){
		this.orderID=orderID;
		this.userID=userID;
		this.addTime=addTime;
		this.status=status;
	}
        public String getOrderID()
        {
            return orderID;
        }
	
}
