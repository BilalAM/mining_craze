package knn;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* File IO Utility Class */
public class IOUtility {

	private static final Path filePath = Paths.get("datasets/knn_dataset");
	private static List<Double> distances = new ArrayList<Double>();
	private static List<String> distanceAppendedLines = new ArrayList<String>();

	private static String[] processString(String s, int columnToPredict) {
		// split the columns BUT dont split the one we need to predict the value
		// (The "classification" column)
		List<String> splittedString = Arrays.asList(s.split(",")).subList(0, columnToPredict - 1);
		return splittedString.toArray(new String[0]);
	}

	// Main KNN ENGINE
	public static List<Double> getDistances(int n, int columnToPredict) throws Exception {

		List<String> fileLines = Files.readAllLines(filePath);
		String lastLine = fileLines.get(fileLines.size() - 1);
		for (String s : fileLines.subList(0, fileLines.size() - 1)) {
			double result = 0;

			String[] a = processString(s, columnToPredict);
			String[] b = processString(lastLine, columnToPredict);
			result = arbitraryEucledianDistance(Arrays.stream(a).mapToDouble(Double::parseDouble).toArray(),
					Arrays.stream(b).mapToDouble(Double::parseDouble).toArray());
			distances.add(result);
			distanceAppendedLines.add(s + "," + result);
		}
		return distances.stream().sorted().limit(n).collect(Collectors.toList());
	}

	private static double arbitraryEucledianDistance(double[] upperPoints, double[] lowerPoints) {

		double result = 0;
		if (upperPoints.length == lowerPoints.length) {
			for (int i = 0; i < upperPoints.length; i++) {
				result += doublePointsProduct(upperPoints[i], lowerPoints[i]);
			}
		} else {
			System.out.println("group points are not equal");
			return 0.0;
		}

		// taking root of the whole product at the end to save processing
		return Math.sqrt(result);
	}

	private static double doublePointsProduct(double x1, double x2) {
		return (Math.pow(((x1 - x2)), 2));
	}

	public static double averageOfDistances(double... points) {
		double product = 0.0;
		for (double d : points) {
			product += (d / points.length);
		}
		return product;
	}

}
