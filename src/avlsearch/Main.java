package avlsearch;

public class Main {

	public static void main(String[] args) {
		
        // Random words experiments
        ExperimentRunner.runExperiment(1000, false);
        ExperimentRunner.runExperiment(5000, false);
        ExperimentRunner.runExperiment(50000, false);

        // Worst-case BST (sorted words)
        ExperimentRunner.runExperiment(1000, true);
        ExperimentRunner.runExperiment(5000, true);
        ExperimentRunner.runExperiment(15000, true);
	}
	
}
