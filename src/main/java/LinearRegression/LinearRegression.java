package LinearRegression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearRegression {
	private static Path path = Paths.get("datasets/linear_regression");

	public Double calculateValue(double independantValue) {
		double y = calculateA() + calcualteB() * independantValue;
		return y;
	}

	public static double calcualteB() {
		double averageDependantValues = LinearRegressionUtils
				.averageOfPoints(getDependantValues().toArray(new Double[0]));
		double averageIndependantValues = LinearRegressionUtils
				.averageOfPoints(getIndependantValues().toArray(new Double[0]));

		// Sum{(X-x)(Y-y)}
		double x = 0;
	
		
		// Sum{(X-x)^2}
		double y = 0;

		for (int i = 0; i < getDependantValues().size(); i++) {

			x += ((averageIndependantValues - getIndependantValues().get(i))
					* (averageDependantValues - getDependantValues().get(i)));
		}

		for (int i = 0; i < getIndependantValues().size(); i++) {
			
			y += Math.pow((averageIndependantValues - getIndependantValues().get(i)),2);
		}
		
		
		String b = "Sum{(X-x)(Y-y)} / Sum(X-x)^2";

		return 0.0;
	}

	private static double calculateA() {
		return 0.0;
	}

	public static List<Double> getDependantValues() {
		List<Double> list = new ArrayList<>();
		String line;
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
				while ((line = reader.readLine()) != null) {
					String[] values = line.split(",");
					list.add(Double.parseDouble(values[1]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Double> getIndependantValues() {
		List<Double> list = new ArrayList<>();
		String line;
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
				while ((line = reader.readLine()) != null) {
					String[] values = line.split(",");
					list.add(Double.parseDouble(values[0]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
