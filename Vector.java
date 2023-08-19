/**
 * This class represents a Vector that inherits from the Matrix class. 
 * @author chaejinhur
 *
 */

public class Vector extends Matrix {
	// constructor of vector 
	public Vector (int c) {
		// calls the Matrix constructor with the parameters
		super(1,c); 
	}
	
	// constructor
	public Vector (int c, double[] linArr) {
		// calls the Matrix constructor with the specified parameters
		super(1, c, linArr); 
	}
	
	public double getElement (int c) {
		// returns the value at row 0 and column c
		return getElement(0, c); 
	}
}
