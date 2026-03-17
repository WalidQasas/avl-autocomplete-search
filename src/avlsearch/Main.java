package avlsearch;

public class Main {

	public static void main(String[] args) {
		
		String searchTerm = "abc";
		
        // Random words experiments
        ExperimentRunner.runExperiment(searchTerm, 1000, false);
        ExperimentRunner.runExperiment(searchTerm, 5000, false);
        ExperimentRunner.runExperiment(searchTerm, 50000, false);

        // Worst-case BST (sorted words)
        ExperimentRunner.runExperiment(searchTerm, 1000, true);
        ExperimentRunner.runExperiment(searchTerm, 5000, true);
        ExperimentRunner.runExperiment(searchTerm, 15000, true);
        
        
	}
	
}
