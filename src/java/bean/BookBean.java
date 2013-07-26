package bean;

public class BookBean {

	private long bookID=0;
	private String bookName="";
	private String author="";
	private String publisher="";	
	private double price=0.0;
	private double priceDiscount=0.0;
	private int pageCount=0;
	private String format="";
	private String simpleContent="";
	private int typeID=0;
	private String bookView="";
	
	public BookBean(){
		
	}
	
	public BookBean(long bookID,
						String bookName,
						String author,
						String publisher,
						double price,
						double priceRebate,
						int pageCount,
						String simpleContent,
                                                String format,
						int typeID,
						String bookView){
		this.bookID=bookID;
		this.bookName=bookName;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.priceDiscount=0.1*priceRebate*price;
		this.pageCount=pageCount;
		this.format=format;
		this.simpleContent=simpleContent;
		this.typeID=typeID;
		this.bookView=bookView;
	}
	
	public long getBookID(){
		return bookID;
	}
	
	public String getBookName(){
		return bookName;
	}
	
	public String getAuthor(){
		if(author.length()==0||author==null)
			return "����";
		else
			return author;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getPriceDiscount(){
		return priceDiscount;
	}
	
	public int getPageCount(){
		return pageCount;
	}
	
	public String getFormat(){
		return format;
	}
	
	public String getSimpleContent(){
		return simpleContent;
	}
	
	public int getTypeID(){
		return typeID;
	}
	
	public String getBookView(){
		return bookView;
	}
        
	
	public void setBookID(long bookID){
		this.bookID=bookID;
	}
	
	public void setBookName(String bookName){
		this.bookName=bookName;
	}
	
	public void setAuthor(String author){
		this.author=author;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	
	public void setPriceByOff(double priceDiscount){
		this.priceDiscount=priceDiscount;
	}
	
	public void setPageCount(int pageCount){
		this.pageCount=pageCount;
	}
	
	public void setFormat(String format){
		this.format=format;
	}
	
	public void setSimpleContent(String simpleContent){
		this.simpleContent=simpleContent;
	}
	
	public void setTypeID(int typeID){
		this.typeID=typeID;
	}
	
	public void setBookView(String bookView){
		this.bookView=bookView;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
