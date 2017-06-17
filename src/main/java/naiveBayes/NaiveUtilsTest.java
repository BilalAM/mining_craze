package naiveBayes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class NaiveUtilsTest {
	private static final Path filePath = Paths.get("datasets/naive_dataset");
	
	private Hashtable<String, List<String>> hashData = new Hashtable<>();
	
	public void loadInHash() throws Exception{
		String line;
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))){
			while((line = reader.readLine()) != null){
				List<String> splittedData = Arrays.asList(line.split(","));
			}
		}
	}

}
