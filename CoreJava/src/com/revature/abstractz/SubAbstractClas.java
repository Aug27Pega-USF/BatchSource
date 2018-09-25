package com.revature.abstractz;

public class SubAbstractClas extends AbstractClas {

	@Override
	public boolean checkUpperCase(String str) {
		
		for(int i = 0; i < str.length(); i++) {
			
			if(!Character.isUpperCase(str.charAt(i))) {
				System.out.println("no");
					return false;
				}
		}
		System.out.println("yes");
		return true;	
	
	}

	@Override
	public String convertLowerToUpper(String inputStr) {
		
				return null;
	}

	@Override
	public int convertToInteger(String inputStr) {
		// TODO Auto-generated method stub
		return 0;
	}

}
