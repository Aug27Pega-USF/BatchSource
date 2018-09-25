package tester;

public class tester {

	public static void main(String[] args) {
		
		boolean vitalsign = true;;	
			
		int i = 1;
		while(vitalsign) {
			 
			System.out.println("Harambe took shot number: " + i );
			
			switch(i) {
			
			case 1:
				System.out.println("DON'T SHOOT MEEEE");
				break;
			case 2:
				System.out.println("SHOOT THE KID'S MOTHER");
				break;
			default:
				System.out.println("BOOM");
			}
			
			if(i==10) {
				vitalsign = false;
				System.out.println("HARAMBZ IS DEAD");
			}
			else
				i++;
		}
		
		i = 0;
		do {
			if(i<3) {
				System.out.println("Today is DAY: " + i);
				System.out.println("Harambz is still dead...");
				i++;
			}
			else
			if(i==3) {
				System.out.println("Today is DAY: " + i);
				System.out.println("HARAMBE HAS RESURRECTED FROM THE DEAD!");
				vitalsign = true;
			}
		}while(!vitalsign);
		
			
	}



}
