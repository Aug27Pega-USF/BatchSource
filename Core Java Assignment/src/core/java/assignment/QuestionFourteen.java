package core.java.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class QuestionFourteen {
	public String switching(int option, int option1, Date option2, String option3) {
		switch(option) {
		case 1:
			return String.format("%.2f", Math.sqrt(option1));
		case 2:
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			return format.format(new Date());
		case 3:
			String[] str = option3.split(" ");
			List<String> returnStr = new ArrayList<String>();
			for(String s : str) {
				returnStr.add(s);
			}
			return returnStr.toString();
		default:
			return "No option selected";
		}
	}
}
