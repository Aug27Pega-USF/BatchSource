public class Q15 {
	Comp C = new Comp();
	float x = 25.0f; 
	float y = 10.0f;
	System.out.println("Using the class' implementation of the 'add' method in the interface: ");
	System.out.println(x + " + " + y + " = " + C.add(x,y));
	System.out.println("Using the class' implementation of the 'subtract' method in the interface: ");
	System.out.println(x + " - " + y + " = " + C.subtract(x,y));
	System.out.println("Using the class' implementation of the 'multiply' method in the interface: ");
	System.out.println(x + " * " + y + " = " + C.multiply(x,y));
	System.out.println("Using the class' implementation of the 'divide' method in the interface: ");
	System.out.println(x + " / " + y + " = " + C.divide(x,y));
	System.out.println();
}
