
public class Q13 {
		 
		   public static void main(String[] args) {
		 
			   System.out.println("Answer to Q13 - Print out triangle. ");
				
				String X = "0101";
				String Y = "0101";
				boolean left = true;
				
				System.out.println(X);

				for(int i = 0; i < 3; i++) {
					if(left) {
						Y = X.substring(1,X.length()) + Y;
						X = X.substring(1,X.length());
						left = false;
					}
					else {
						Y = X.substring(0,X.length()-1) + Y;
						X = X.substring(0,X.length()-1);
						left = true;
					}
					System.out.println(X);
				}
				System.out.println(Y);
				System.out.println();
				
		   }
		}


