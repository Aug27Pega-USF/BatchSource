import java.util.ArrayList;

public class Q12 {
	ArrayList<Integer> numbers = new ArrayList<Integer>(100);
	for (int i = 1; i <= 100; i++){
   numbers.add(i);
   System.out.println(numbers.get(i - 1));

}
