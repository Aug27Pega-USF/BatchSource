package pizza.parlor;

public class Food {
	public Food(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	private String name;
	private double price;
	
	
}
