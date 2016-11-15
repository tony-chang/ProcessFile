package example;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

	private Processor p;
	private final String FILENAME = "testfile.txt";
	private final String FILENAME2 = "C://data.txt";
	private HashMap<String, List>returnHash = new HashMap<String, List>();
	private final String RESULT_FILENOTFOUND = "0";
	private final String RESULT_FILEFOUND = "1";
	
	@Before
	public void setup(){
		p = new Processor();
	}
	
	@Test
	public void GetContentFromNonExistingFile() throws Exception{
		String _localKey = "";
		try{
			p.setFilename(FILENAME);
			returnHash = p.getContent();
			
			for(Map.Entry<String, List> e : returnHash.entrySet()){
				_localKey = e.getKey();
				System.out.println("line 43: UniteTest.java -> key: '" + _localKey + "'");  
			}
			assertEquals(RESULT_FILENOTFOUND, _localKey);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void GetContentFromExistingFile() throws Exception{
		String _localKey = "";
		try{
			p.setFilename(FILENAME2);
			returnHash = p.getContent();
			
			for(Map.Entry<String, List> e : returnHash.entrySet()){
				_localKey = e.getKey();
				System.out.println("line 65: UniteTest.java -> key: '" + _localKey + "'");
			}
			assertEquals(RESULT_FILEFOUND, _localKey);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
