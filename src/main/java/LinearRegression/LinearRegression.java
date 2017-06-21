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

	private static double calcualteB() {
		
		
		return 0.0;
	}

	private static double calculateA() {
		return 0.0;
	}

	public static List<Double> getDependantValues() throws Exception {
		List<Double> list = new ArrayList<>();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				list.add(Double.parseDouble(values[0]));
			}
		}
		return list;
	}

}
