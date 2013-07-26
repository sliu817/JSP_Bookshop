package bean;

import java.util.Hashtable;
import java.io.Serializable;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 6152499994129454808L;
	
	private Hashtable myBooks = new Hashtable();
	
	public Cart(){}
	

	public void addBook(String bookID,int bookCount){
		if(myBooks.contains(bookID)){
			int tempCount = ((Integer)myBooks.get(bookID)).intValue();
			tempCount = tempCount + bookCount;
			myBooks.put(bookID, new Integer(tempCount));
		}
		else{
			myBooks.put(bookID, new Integer(bookCount));
		}		
	}
	
	public boolean minusBooks(String bookID,int bookCount){
		if(myBooks.containsKey(bookID)){
			int tempCount = ((Integer)myBooks.get(bookID)).intValue();
			tempCount = tempCount-bookCount;
			if(tempCount <= 0)
				deleteBook(bookID);
			else
				myBooks.put(bookID, new Integer(tempCount));
			return true;
		}
		else{
			return false;
		}
	}
	
	public Hashtable listMyBooks(){
		return myBooks;
	}
	
	public boolean deleteBook(String bookID){
		if(myBooks.remove(bookID)==null)
			return false;
		else
			return true;
	}

	public void clear(){
		myBooks.clear();
	}
}
