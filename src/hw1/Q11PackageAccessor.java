package hw1;
import hw1part2.FloatProviderQ11;

public class Q11PackageAccessor {
	
	float floatadd() {
		System.out.println(FloatProviderQ11.a + "+" +FloatProviderQ11.b);
		return FloatProviderQ11.a+FloatProviderQ11.b;
	}
	
}
