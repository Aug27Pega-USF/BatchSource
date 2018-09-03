package homework;

public class UppAndLow implements UpperAndLower {

	@Override
	public boolean containsUppercase(String s) {
		// TODO Auto-generated method stub
		char[] ary = s.toCharArray();
		for(char i: ary) {
			if(Character.isUpperCase(i))
				return true;
		}
		return false;
	}

	@Override
	public String conversion(String s) {
		// TODO Auto-generated method stub
		String newb = "";
		char[] ary = s.toCharArray();
		for(char i: ary) {
			if(Character.isLowerCase(i))
				newb += Character.toUpperCase(i);
			else newb += i;
		}
		return newb;
	}

	@Override
	public int add10(String s) {
		// TODO Auto-generated method stub
		int y = Integer.parseInt(s);
		y+=10;
		return y;
	}
}
