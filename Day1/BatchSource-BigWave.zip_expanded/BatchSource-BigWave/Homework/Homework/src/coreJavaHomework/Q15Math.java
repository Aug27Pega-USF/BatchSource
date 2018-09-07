package coreJavaHomework;

public class Q15Math implements Q15MathInterface {
	
	@Override
	public float addition(float x, float y) {
		return x+y;	}
	@Override
	public float subtraction(float x, float y) {
		return x-y;	}
	@Override
	public float multiplication(float x, float y) {
		return x*y;	}
	@Override
	public float division(float x, float y) {
		return x/y;
	}
}
