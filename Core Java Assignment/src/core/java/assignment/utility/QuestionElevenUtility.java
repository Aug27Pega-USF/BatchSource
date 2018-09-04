package core.java.assignment.utility;
import java.util.Random;

public class QuestionElevenUtility {
	private float firstFloat;
	private float secondFloat;
	
	public QuestionElevenUtility() {
		Random rand = new Random();
		firstFloat = rand.nextFloat();
		secondFloat = rand.nextFloat();
	}
	public float getFirstFloat() {
		return firstFloat;
	}
	public void setFirstFloat(float firstFloat) {
		this.firstFloat = firstFloat;
	}
	public float getSecondFloat() {
		return secondFloat;
	}
	public void setSecondFloat(float secondFloat) {
		this.secondFloat = secondFloat;
	}
}
