package LinearRegression;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LinearRegression {
	private static Path path = Paths.get("/datasets/linear_regression.txt");
	
	
	public Double calculateValue(double independantValue){
		double y = calculateA() + calcualteB() * independantValue;
		return y;
	}
	
	private static double calcualteB(){
		return 0.0;
	}
	private static double calculateA(){
		return 0.0;
	}
	
}
