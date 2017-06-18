package naiveBayes;

import java.util.Arrays;

import java.util.List;

public class NaiveUtilsTest {

	public void test() throws Exception {
		String line = "1,Red,Sports,Domestic,Yes";
		ClassificationFeature<String, List<String>> classA = new ClassificationFeature<>();
		classA.setKey("approved");
		classA.setValue(Arrays.asList(line.split(",")));

	}
}

class ClassificationFeature<K, V> {
	private K key;
	private V value;

	public ClassificationFeature(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public ClassificationFeature() {

	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
