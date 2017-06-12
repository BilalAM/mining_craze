package knn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) throws Exception {

		IOUtility util = new IOUtility();
		for (Double s : util.knnIt(12, 3)) {
			
			System.out.println(s);
		}
		
		System.out.println("s");

	}
}
