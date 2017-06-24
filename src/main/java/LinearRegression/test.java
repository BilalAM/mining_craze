package LinearRegression;

public class test {
	public static void main(String[] args) {
		try {
			for (Double d : LinearRegression.getIndependantValues()) {
				System.out.println(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
