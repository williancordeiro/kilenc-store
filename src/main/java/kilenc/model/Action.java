package kilenc.model;

public class Action extends Game{

	private double price;
	
	public Action(String name, int age, double price) {
		super(name, age, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Action";
	}

}
