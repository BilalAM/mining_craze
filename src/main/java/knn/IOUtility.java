package knn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	public List<Double> knnIt(int neighbours) throws Exception {
		Stream<Double> shortestNeighbours = getDistances().stream().sorted().limit(neighbours);
		return shortestNeighbours.collect(Collectors.toList());
	}

	private static String[] processString(String s) {
		String[] splittedText = s.split(",");
		return splittedText;
	}

	// Main KNN ENGINE
	private static List<Double> getDistances() throws Exception {
		List<String> fileLines = Files.readAllLines(filePath);
		String lastLine = fileLines.get(fileLines.size() - 1);
		for (String s : fileLines.subList(0, fileLines.size() - 2)) {
			String[] a = processString(s);
			String[] b = processString(lastLine);
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
