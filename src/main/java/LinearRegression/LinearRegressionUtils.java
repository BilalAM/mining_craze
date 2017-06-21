package LinearRegression;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LinearRegressionUtils {
	/* taken from knn.KnnUtils class*/
	public static double averageOfPoints(Double...values) {
		double product = 0.0;
		for (double d : values) {
			product += (d / values.length);
		}
		return product;
	}
	
	
}
