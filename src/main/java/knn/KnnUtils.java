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
	public static double arbitraryEucledianDistance(double[] upperPoints, double[] lowerPoints) {

		double result = 0;
		if (upperPoints.length == lowerPoints.length) {
			for (int i = 0; i < upperPoints.length; i++) {
				result += KnnUtils.doublePointsProduct(upperPoints[i], lowerPoints[i]);
			}
		} else {
			System.out.println("group points are not equal");
			return 0.0;
		}

		// taking root of the whole product at the end to save processing
		return Math.sqrt(result);
	}

}
