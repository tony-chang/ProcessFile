package example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processor {

	private String filename;
	private String content;
	private List<String>list;
	private HashMap<String, List>returnHash = new HashMap<String, List>();
	
	public Processor(){
		this.filename = null;
		this.content = null;
		this.list = null; 
	}
	
	public Processor(String fname){
		this.filename = fname;
		this.content = "test";
		this.list = new ArrayList<>();
	}
	
	public String getFilename(){
		return this.filename;
	}
	
	public boolean setFilename(String fname){
		if(!fname.isEmpty()){
			this.filename = fname;
			return true;
		}else{
			return false;			
		}
	}
	
	public HashMap<String, List> getContent(){
		try(Stream<String>stream = Files.lines(Paths.get(this.filename))){
			this.list = stream.collect(Collectors.toList());
			returnHash.put("1",  this.list);
			stream.close();
			
			return this.returnHash;
		}catch(IOException e){
			// Add code to log error
			returnHash.put("0", this.list);
			
			return this.returnHash;
		}
	}
	
	
	
}
