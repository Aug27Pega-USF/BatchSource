package basicbank;

import java.io.Serializable;

public class Admin extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	public Admin(String name, String password) {
		// TODO Auto-generated constructor stub
		super(name, password);
	}

	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + "]";
	}
}
