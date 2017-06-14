package knn;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* File IO Utility Class */
public class KnnRegression {

	private static final Path filePath = Paths.get("datasets/knn_dataset");
	private static List<Double> distances = new ArrayList<Double>();
	private static List<String> distanceAppendedLines = new ArrayList<String>();
	private static int _columnToPredict;

	private static String[] processString(String s, int columnToPredict) {
		// split the columns BUT dont split the one we need to predict the value
		// (The "classification" column)
		List<String> splittedString = Arrays.asList(s.split(",")).subList(0, columnToPredict - 1);
		return splittedString.toArray(new String[0]);
	}

	// Main KNN ENGINE
	@SuppressWarnings("unused")
	public static Double calculateValue(int n, int columnToPredict) throws Exception {

		double average = 0.0;
		_columnToPredict = columnToPredict;
		List<String> fileLines = Files.readAllLines(filePath);
		List<Double> averages = new ArrayList<>();
		String lastLine = fileLines.get(fileLines.size() - 1);
		String[] lastRecord = processString(lastLine, columnToPredict);

		for (String record : fileLines.subList(0, fileLines.size() - 1)) {
			double result = 0;

			String[] lineRecords = processString(record, columnToPredict);
			result = arbitraryEucledianDistance(Arrays.stream(lineRecords).mapToDouble(Double::parseDouble).toArray(),
					Arrays.stream(lastRecord).mapToDouble(Double::parseDouble).toArray());
			distances.add(result);
			distanceAppendedLines.add(record + "," + result);
		}

		sort(distanceAppendedLines);
		for (String value : distanceAppendedLines.stream().limit(n).collect(Collectors.toList())) {
			Double doubleValue = Double.valueOf(Arrays.asList(value.split(",")).get(columnToPredict - 1));
			averages.add(doubleValue);
		}

		return averageOfDistances(averages.toArray(new Double[0]));
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

	public static double averageOfDistances(Double... points) {
		double product = 0.0;
		for (double d : points) {
			product += (d / points.length);
		}
		return product;
	}

	private static void sort(List<String> list) {
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Double.valueOf(Arrays.asList(o1.split(",")).get(_columnToPredict))
						.compareTo(Double.valueOf(Arrays.asList(o2.split(",")).get(_columnToPredict)));
			};
		});
	}

}
