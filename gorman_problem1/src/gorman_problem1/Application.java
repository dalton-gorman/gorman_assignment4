package gorman_problem1;

//Create a separate class called Application
public class Application {

	//contains a main method which illustrates the use of 
	//DuplicateCounter by calling both the remove and 
	//count methods
	public static void main(String[] args) {
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove("problem1.txt");
		duplicateRemover.write("unique_words.txt");

	}

}
