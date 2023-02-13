package kilenc.model;

public class Adventure extends Game{
	
	private double price;

	public Adventure(String name, int age, double price) {
		super(name, age, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Adventure";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
