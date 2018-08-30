package core;

public abstract class Q18Abstractclass {
	public abstract boolean uppercasecheck(String s);
	public abstract String makeUppercase(String s);
	public abstract void add10(String s);
}

class Q18subclass extends Q18Abstractclass{

	@Override
	public boolean uppercasecheck(String s) {
			return !s.equals(s.toLowerCase());
	}

	@Override
	public String makeUppercase(String s) {
		return s.toUpperCase();
	}

	@Override
	public void add10(String s) {
		int result = Integer.parseInt(s);
		System.out.println(result+10);
	}
	
	
	
}