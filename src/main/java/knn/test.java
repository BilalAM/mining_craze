package knn;

public class test {

	public static void main(String[] args) throws Exception {

		IOUtility util = new IOUtility();
		for (Double d : util.knnIt(10)) {
			System.out.println(d);
		}
		System.out.println("hello");

	}
}
