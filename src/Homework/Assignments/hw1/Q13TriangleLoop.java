package Homework.Assignments.hw1;

public class Q13TriangleLoop {
	public void Q13(){
		String print="";
		String one="1 ";
		String zero="0 ";
		for(int i=0;i!=4;i++) {
			switch(i%3) {
			case 0:
				print=zero+print;
				break;
			case 1:
				print=one+print;
				break;
			case 2:
				print=print+one;
				break;
			default:
				break;
			}
			
			System.out.println(print);
		}
		
	}
}
