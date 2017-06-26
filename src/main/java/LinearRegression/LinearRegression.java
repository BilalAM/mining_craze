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
	private static double averageDependantValues;
	private static double averageIndependantValues;

	public Double calculateValueAgainst(double independantValue) {
		double y = calculateA() + calculateB() * independantValue;
		return y;
	}

	private static double calculateB() {
		averageDependantValues = LinearRegressionUtils.averageOfPoints(getDependantValues().toArray(new Double[0]));
		averageIndependantValues = LinearRegressionUtils.averageOfPoints(getIndependantValues().toArray(new Double[0]));

		// Sum{(X-x)(Y-y)}
		double x = 0;

		// Sum{(X-x)^2}
		double y = 0;

		for (int i = 0; i < getDependantValues().size(); i++) {

			x += ((getIndependantValues().get(i) - averageIndependantValues)
					* (getDependantValues().get(i) - averageDependantValues));
		}

		for (int i = 0; i < getIndependantValues().size(); i++) {

			y += Math.pow((getIndependantValues().get(i) - averageIndependantValues), 2);
		}

		// Sum{(X-x)(Y-y)} / Sum(X-x)^2"

		return x / y;
	}

	private static double calculateA() {

		// a = y - bx;
		averageDependantValues = LinearRegressionUtils.averageOfPoints(getDependantValues().toArray(new Double[0]));
		averageIndependantValues = LinearRegressionUtils.averageOfPoints(getIndependantValues().toArray(new Double[0]));
		return averageDependantValues - calculateB() * averageIndependantValues;
	}

	private static List<Double> getDependantValues() {
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

	private static List<Double> getIndependantValues() {
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
