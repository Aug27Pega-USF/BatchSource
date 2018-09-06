package pizza.parlor;

import java.util.ArrayList;

public class Pizza extends Food{
	
	enum Size{
		S, M, L;
	}
	
	private ArrayList<String> ToppingsList;
	private Size size;
	
	public Pizza() {
		super("Pizza", 0);
		ToppingsList=new ArrayList<String>();
	}
	
	
	public void setsize(int num) {
		switch(num) {
		case 1:
			size= Size.S;
			break;
		case 2:
			size= Size.M;
			break;
		case 3:
			size= Size.L;
			break;
		}
	}
	
	public void addTopping(String topping) {
		ToppingsList.add(topping);
	}
	
	public String getName() {
		String name="";
		name+= size;
		name+= " Pizza";
		if (!ToppingsList.isEmpty()) {
			name+=" w/ ";
			for(int i=0;i!=ToppingsList.size()-1;i++) {
				name+= ToppingsList.get(i) + ",";
			}
			name+= ToppingsList.get(ToppingsList.size()-1);
		}
		return name;
	}
	
	public double getPrice() {
		double tempPrice=0;
		switch(size) {
		case S:
			tempPrice=10;
			break;
		case M:
			tempPrice=12.5;
			break;
		case L:
			tempPrice=15;
			break;
		}
		tempPrice+=(ToppingsList.size()*1.25);
		double priceRounded = Math.round(tempPrice * 100D) / 100D;
		return priceRounded;
	}

}
