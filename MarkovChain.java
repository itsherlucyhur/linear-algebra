/**
 * This class represents a Markov Chain to create a matrix of predicted future states
 * with the help of a state vector and a transiton vector. 
 * @author chaejinhur
 *
 */

public class MarkovChain {
	private Vector stateVector; 
	private Matrix transitionMatrix; 

	// constructor for Markov Chain to initialize the parameters 
	public MarkovChain (Vector sVector, Matrix tMatrix) {
		stateVector = sVector;
		transitionMatrix = tMatrix; 
	}
	
	// checks if the instance variables are valid for a Markov Chain 
	public boolean isValid() {
		
		final int tRows = transitionMatrix.getNumRows();
		final int tCols = transitionMatrix.getNumCols();
		final int sVCols = stateVector.getNumCols();

		
		// checks if the transition matrix's # of rows and columns are equal and matches the # of columns in the state vector
		if ((tRows != tCols) || (tCols != sVCols)) {
			return false;
		}

		double tMatSum = 0;
		double sVecSum = 0;

		for (int i = 0; i < tRows; i++) {
			tMatSum = 0;

		for (int j = 0; j < tCols; j++) {
			tMatSum += transitionMatrix.getElement(i, j);
		}

		
		// checks that the sum of values in transition matrix is very close to 1.0 
		if (!(tMatSum > 0.99 && tMatSum < 1.01)) {
			return false;
			}
		}

		for (int i = 0; i < sVCols; i++) {
			sVecSum += stateVector.getElement(i);
		}

		// checks that sum of state vector values is very close to 1.0
		if (!(sVecSum > 0.99 && sVecSum < 1.01)) {
			return false;
		}
		return true;
	}


	
	// method to compute the probability matrix of the Markov chain 
	public Matrix computeProbabilityMatrix (int numSteps) {
		
		// tests if this is a valid Markov chain
		if (!isValid()) { 
			// returns null if it's not a valid Markov chain
			return null; 
		}
		
		Matrix result = transitionMatrix; 
		
		for (int i = 0; i < numSteps - 1; i++) {
			// transition matrix multiplied by itself numSteps - 1 times
			result = result.multiply(transitionMatrix); 
		}
		
		// state vector multiplied by the resulting matrix
		result = stateVector.multiply(result); 
		
		// returns the resulting vector
		return result;
	}
	
}
