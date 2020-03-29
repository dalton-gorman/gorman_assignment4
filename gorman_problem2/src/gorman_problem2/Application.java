package gorman_problem2;

//Create a separate class called Application
public class Application {

	//contains a main method which illustrates the use of 
	//DuplicateCounter by calling both the remove and 
	//write methods
	public static void main(String[] args) {
		
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");

	}

}
