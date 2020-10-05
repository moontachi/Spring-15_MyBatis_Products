package product.model;

public class Product {
	
	private int num;
	private String name; 
	private String company; 
	private String image; 
	private int stock; 
	private int price; 
	private String category; 
	private String contents; 
	private int point; 
	private String inputdate;
	
	private int orderqty;	//주문수량 담을 변수하나 추가하기
	
	
	
	
	public Product() {
		
	}
	public Product(int num, String name, String company, String image, int stock, int price, String category,
			String contents, int point, String inputdate) {
		super();
		this.num = num;
		this.name = name;
		this.company = company;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.contents = contents;
		this.point = point;
		this.inputdate = inputdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	} 
	public int getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}
	
	
	

}
