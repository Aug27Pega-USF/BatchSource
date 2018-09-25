public class Q3 {
	public static String reverse (String source) {
		if(source == null || source.isEmpty()) {
			return source; 
		}
		String reverse = "";
		for(int i = source.length() -1; i>=0; i--) {
			reverse = reverse + source.charAt(i);
		}
		return reverse;
	}
}