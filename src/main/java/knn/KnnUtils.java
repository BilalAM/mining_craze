package knn;

import java.util.Arrays;
import java.util.List;

public class KnnUtils {
	
	public static double doublePointsProduct(double x1, double x2) {
		return (Math.pow(((x1 - x2)), 2));
	}

	public static double averageOfDistances(Double... points) {
		double product = 0.0;
		for (double d : points) {
			product += (d / points.length);
		}
		return product;
	}
	public static String[] processString(String s, int columnToPredict) {
		// split the columns BUT dont split the one we need to predict the value
		// (The "classification" column)
		List<String> splittedString = Arrays.asList(s.split(",")).subList(0, columnToPredict - 1);
		return splittedString.toArray(new String[0]);
	}

}
