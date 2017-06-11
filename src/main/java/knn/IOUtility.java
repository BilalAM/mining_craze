package knn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* File IO Utility Class */
public class IOUtility {

	private static final Path filePath = Paths.get("/mining_craze/datasets/knn_dataset.txt");
	private static List<Double> distances = new ArrayList<Double>();
	private static double[] upperPoints = new double[]{};
	private static double[] lowerPoints = new double[]{};
	
	

	private List<Double> getDistances() throws Exception{
		List<String> fileLines = Files.readAllLines(filePath);
		
		return distances;
		
		
		
	}
	
	

	public static double arbitraryEucledianDistance(double[] upperPoints, double[] lowerPoints) {
		
		double result = 0;
		if (upperPoints.length == lowerPoints.length) {
			for (int i = 0; i < upperPoints.length; i++) {
				result += doublePointsProduct(upperPoints[i], lowerPoints[i]);
			}
		} else {
			System.out.println("group points are not equal");
			return 0.0;
		}
		
		//taking root of the whole product at the end to save processing
		return Math.sqrt(result);
	}

	private static double doublePointsProduct(double x1, double x2) {
		return (Math.pow(((x1 - x2)), 2));
	}
}
