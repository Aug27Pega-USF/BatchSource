package utility;



public  abstract class QEighteenUtility{
	protected String str;
	
	public abstract boolean checkUppercase();
	public abstract String toUppercase();
	public abstract int toIntegerAndAdd();
	
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
}