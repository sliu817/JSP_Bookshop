package bean;

import java.util.*;

public class ItemsArray {
	
	ArrayList list=null;
	
	public ItemsArray(){
		list=new ArrayList();
	}
	
	public void setList(ArrayList lt){
		list=(ArrayList)lt.clone();
	}
	
	public ArrayList getList(){
		return list;
	}

	public void addItem(BookBean item){
		list.add(item);
	}
}
