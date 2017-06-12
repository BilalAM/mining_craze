package knn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* File IO Utility Class */
public class IOUtility {

	// TODO HAVE TO CHANGE THE PATH
	private static final Path filePath = Paths.get("/home/bilalam/git/mining_craze/datasets/knn_dataset");
	private static List<Double> distances = new ArrayList<Double>();
	private static double[] upperPoints = new double[] {};
	private static double[] lowerPoints = new double[] {};

	/* Gets The Smallest n Number of calculated distances */
	public List<Double> knnIt(int neighbours, int columnToPredict) throws Exception {
		// Stream<Double> shortestNeighbours =
		// getDistances(columnToPredict).stream().limit(neighbours);
		// return shortestNeighbours.collect(Collectors.toList());

		return getDistances(columnToPredict).stream().limit(neighbours).collect(Collectors.toList());
	}

	private static String[] processString(String s, int columnToPredict) {
		// split the columns BUT dont split the one we need to predict the value
		// (The "classification" column)
		List<String> splittedString = Arrays.asList(s.split(",")).subList(0, columnToPredict - 1);
		return splittedString.toArray(new String[0]);
	}

	// Main KNN ENGINE
	private static List<Double> getDistances(int columnToPredict) throws Exception {
		List<String> fileLines = Files.readAllLines(filePath);
		String lastLine = fileLines.get(fileLines.size() - 1);
		for (String s : fileLines.subList(0, fileLines.size() - 1)) {
			String[] a = processString(s, columnToPredict);
			String[] b = processString(lastLine, columnToPredict);
			distances.add(arbitraryEucledianDistance(Arrays.stream(a).mapToDouble(Double::parseDouble).toArray(),
					Arrays.stream(b).mapToDouble(Double::parseDouble).toArray()));
		}
		return distances;
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
}
