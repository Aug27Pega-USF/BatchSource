package homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Question14 {

	public static void switching(int n) {
		switch(n)
		{
		case 1:
			double a = 16;
			a = Math.sqrt(a);
			System.out.println(a);
			break;
		case 2:
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Calendar today = Calendar.getInstance();
			System.out.println(df.format(today.getTime()));
			break;
		case 3:
			String s ="I am learning Core Java";
			String[] sa = s.split("\\s+");
			for(String i: sa)
				System.out.print(i + ":");
			break;
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		switching(1);
		switching(2);
		switching(3);
	}

}
