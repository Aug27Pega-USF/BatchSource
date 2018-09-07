package pizza.parlor;

import java.util.ArrayList;

public class Order {
	String customerUsername;
	double taxrate;
	ArrayList<Food> foodList;
	boolean isDelivery;
	boolean isReady;
	
	public Order(String customerUsername) {
		super();
		this.customerUsername = customerUsername;
		this.taxrate = .00825;
		this.foodList = new ArrayList<Food>();
		this.isDelivery = false;
		this.isReady = false;
	}
	
	public double calculatePrice() {
		double orderPrice=0;
		for (int i=0;i!=foodList.size();i++) {
			orderPrice+=foodList.get(i).getPrice();
		}
		if(isDelivery) {
			orderPrice+=2.99;
		}
		return orderPrice*(taxrate+1);
	}
	
	public String displayOrder() {
		String order = "";
		order+="Customer: "+ customerUsername +"\n";
		if(isDelivery) {
			order+="Carryout ";
		}
		else {
			order+="Delivery ";
		}
		order+="Order:\n";
		for (int i=0;i!=foodList.size();i++) {
			order+= (i+1)+ ". " + foodList.get(i).getName() +  String.format("$%.2f", foodList.get(i).getPrice() +"\n") ;
		}
		return order;
		//use is delivery or isready
	}
	
	public void isDelivery() {
		isDelivery=true;
	}
	
	public void isReady() {
		isReady=true;
	}
	
	public void setTaxRate(double taxrate) {
		this.taxrate=taxrate;
	}
	
	
}
