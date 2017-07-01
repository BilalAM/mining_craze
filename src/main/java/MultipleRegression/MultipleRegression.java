package MultipleRegression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MultipleRegression {

	private static final Path filePath = Paths.get("datasets/multiple_regression");

	public static void main(String[] args) {
		List<Double> g = getColumnData(3);
		System.out.println("d");
	}

	private static List<Double> getColumnData(int column) {
		if (column <= 0) {
			System.out.println("column cannot be 0 or negative");
			return null;
		} else {
			List<Double> data = new ArrayList<>();
			String line;
			try {
				try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
					while ((line = reader.readLine()) != null) {
						String[] splittedData = line.split(",");
						if (column > splittedData.length) {
							System.out.println("column does not exists");
							return null;
						}
						data.add(Double.parseDouble(splittedData[column - 1]));
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
	}

}
