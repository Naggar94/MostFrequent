import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static int greatestCount = 0;
	public static String mostFrequentWord = "";
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		try {
	      File myObj = new File("src/data.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		if(words.size() == 0) {
			System.out.println("There are no words given in the array");
		}
		
		words.forEach(s -> {
			Integer count = map.get(s);
			if(count != null) {
				if(count+1 > greatestCount) {
					mostFrequentWord = s;
					greatestCount = count + 1;
				}
				map.put(s, count+1);
			}else {
				map.put(s, 1);
				if(greatestCount < 1 ) {
					mostFrequentWord = s;
					greatestCount = 1;
				}
			}
			
		});
		
		System.out.println(mostFrequentWord);
	}
}
