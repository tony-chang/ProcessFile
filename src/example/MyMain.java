package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyMain {

	public static void main(String[] args) {
		List<String>rows = new ArrayList<>();
		HashMap<String, List> hm = new HashMap<String, List>();
		String file1 = "C://data.txt";
		String file2 = "C://argh.txt";
		Processor p = new Processor(file1);
		hm = p.getContent();
		
		// Loop through hash with foreach loop
		hm.forEach((k, v) -> {
			if("0".equals(k)){
				System.out.println("line 22: ERROR: file not found");
			}else if("1".equals(k)){
				System.out.println("line 24: Found file and content is: '" + v + "'");
			}
		});	
	}
}
