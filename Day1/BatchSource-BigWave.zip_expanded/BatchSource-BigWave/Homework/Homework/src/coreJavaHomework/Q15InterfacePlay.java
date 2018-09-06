package coreJavaHomework;

public class Q15InterfacePlay{
	static float x=5f, y=3.2f;
	
	public static void tester(){
		Q15Math math = new Q15Math();
		System.out.println(x+" + " +y+" = "+ math.addition(x,y));
		System.out.println(x+" - " +y+" = "+ math.subtraction(x,y));
		System.out.println(x+" * " +y+" = "+ math.multiplication(x,y));
		System.out.println(x+" / " +y+" = "+ math.division(x,y));
		System.out.println();
	}
	
	
}

	

