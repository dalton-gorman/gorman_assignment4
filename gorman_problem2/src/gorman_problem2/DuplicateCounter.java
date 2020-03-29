package gorman_problem2;

//import java classes
import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

//create public class DuplicateCounter
public class DuplicateCounter {
	
	//create instance variable wordCounter to store the counts
	private Integer wordCounter;
	
	//create a map of strings
	private Map<String , Integer> map;
	
	public DuplicateCounter() {
		
		//set word counter to 0
		this.wordCounter = 0;
		//create new hashmap
		this.map = new HashMap<>();
	
	}
	
	//create method called count that takes a single parameter called dataFile of type string
	public void count(String dataFile) {
		
		Scanner reader;
		
		try {
			
			reader = new Scanner(new File(dataFile));
			
			while(reader.hasNextLine()) {
				
				String line = reader.nextLine().trim();
				String[] words = line.split("[\\W]+");
				
				for(String word : words) {
					
					//convert all characters / words to lowercase
					word = word.toLowerCase();
					
					//create a map of strings to count how many times each word occurs in data file
					this.wordCounter = map.get(word);
					this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
					map.put(word, this.wordCounter);
					
				}
			}
			
			//close the reader scanner
			reader.close();
		
		//find and catch exceptions
		} catch(FileNotFoundException except) {
			
			System.out.println("Could not find the file: " +dataFile);
			System.exit(1);
			
		}
	}
	
	//create instance method called write with parameter string outpuFile
	public void write(String outputFile) {
		
		//imported classes to write the outputFile (unique_word_counts.txt)
		FileWriter fileWriter;
		PrintWriter printWriter;
		
		try {
			
			fileWriter = new FileWriter(new File(outputFile));
			printWriter = new PrintWriter(fileWriter);
			
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				
				printWriter.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
				
			}
			
			System.out.println("Map data written to file: " + outputFile);
			printWriter.flush();
			fileWriter.close();
			printWriter.close();
			
		//catch all exceptions	
		} catch (IOException except) {
			
			System.out.println("Error writing to file: " +outputFile + ":" + except.getMessage());
			System.exit(1);
			
		}
	}
}
