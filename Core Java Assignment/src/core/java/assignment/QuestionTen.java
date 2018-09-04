package core.java.assignment;

public class QuestionTen {
	public int findMinOfTwo(String[] twoNum) {
		int[] nums = {Integer.parseInt(twoNum[0]), Integer.parseInt(twoNum[1])};
		return nums[0] < nums[1] ? nums[0] : nums[1];
	}
}
