
public class Q14 {
	int x = 3;
	
	switch(x) {
	case 1:
		int sqr = (int) Math.sqr(25);
		System.out.println("case 1:");
		System.out.println("sqr of 25 = " + sqr);
		break;
	case 2:
		Date date = new Date();
		System.out.println("case 2:");
		System.out.println(date.toString());
		break;
	case 3:
		System.out.println("case 3:");
		String D = "I am learning Core Java";
		String stringArr[] = new String[5];
		StringBuilder tStr = new StringBuilder();
		int i = 0;
		for(char c: D.toCharArray()) {

			if(c == ' ') {
				stringArr[i] = tStr.toString();
				i++;
				tStr.delete(0, tStr.length());
			}
			else
			if(c !=' ' ) {
				tStr.append(c);
			}
			 
			if(i == 4) {
				stringArr[i] = tStr.toString();
			}
		}
		System.out.println("The following are the contents of the string array after splitting the string '" + D + "'.");
		for(int j = 0; j < 5; j++) {
			System.out.println("Array[" + j + "] = " + stringArr[j].toString());
		}
		break;
	default:
		System.out.println("This is the default switch case...");
		break;
	}
	System.out.println();
}

}
