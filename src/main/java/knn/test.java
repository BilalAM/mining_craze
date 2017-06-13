package knn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class test {

	public static void main(String[] args) throws Exception {
		IOUtility util = new IOUtility();
		for(Double d : IOUtility.getDistances(10, 3)){
			System.out.println(d);
		}
		System.out.println("hello");
	}
}
