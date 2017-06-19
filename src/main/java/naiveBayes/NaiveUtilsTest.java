package naiveBayes;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class NaiveUtilsTest {

	public void test() throws Exception {
		String line = "1,Red,Sports,Domestic,Yes";
		ClassificationFeature classA = new ClassificationFeature();
		classA.setKey("approved");
		classA.setValue(Arrays.asList(line.split(",")));
	}
}

class ClassificationFeature {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	private List<String> value;

	public ClassificationFeature(String key, List<String> value) {
		this.key = key;
		this.value = value;
	}

	public ClassificationFeature() {

	}

}
