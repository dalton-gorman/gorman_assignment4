package gorman_problem1;

import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;

//create class called duplicate remover
public class DuplicateRemover {
	
	//create an instance variable of string type called
	//uniqueWords that stores the unique words
	Set<String> uniqueWords;
	
	//uses a Set of Strings to eliminate
	//duplicate words from the file referenced by dataFile
	void remove(String dataFile) {
		
		Scanner reader = null;
		
		try {
			
			//store strings from problem1.txt in a set
			uniqueWords = new LinkedHashSet<>();
			
			//
			reader = new Scanner(new File(dataFile));
			
			//read file line by line
			while(reader.hasNextLine()) {
				
				String line = reader.nextLine();
				
				//define a word as anything before or after a space
				String[] words = line.split(" ");
				
				//convert all words to lowercase
				for(int i = 0; i < words.length; i++) {
					
					String lowerCase = words[i].toLowerCase();
					uniqueWords.add(lowerCase);
					
				}
				
			}
			
		//catch any exceptions	
		} catch(Exception e) {
			
			System.out.println("Error opening " +dataFile);
			
		}
		
		//close the scanner
		if(reader != null) {
			
			reader.close();
		
		}

	}
	
	//instance method called write that
	//takes a single parameter called outputFile
	void write(String outputFile) {
		
		FileWriter fileOutput = null;
		
		try {
			
			//open the output file
			fileOutput = new FileWriter(outputFile);
			
			//look through the uniqueWords set
			for(String setUniWrd:uniqueWords) {
				
				//write words in output file
				fileOutput.write(setUniWrd + "\n");
			
			}
			
			//show that output file is written
			System.out.println("File " + outputFile + " has been written");
			
			//close output file
			fileOutput.close();
		
		//catch any exceptions
		} catch(Exception e) {
			
			System.out.println("Error writing " + outputFile);
		
		}
		
	}

}
