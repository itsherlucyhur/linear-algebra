/**
 * This class represents a matrix. Each matrix has a number of rows 
 * and a number of columns. 
 * @author chaejinhur (Lucy Hur) 
 *
 */

public class Matrix {
	private int numRows; 
	private int numCols; 
	private double[][] data; 
	
	// constructor that creates a matrix with the given number of rows and columns
	public Matrix (int r, int c) {
		numRows = r; 
		numCols = c; 
		data = new double[r][c];
	}
	
	// constructor with 2D array data with elements in linArr
	public Matrix(int r, int c, double[] linArr) {
		numRows = r; 
		numCols = c; 
		data = new double[r][c]; 
		int count = 0; 
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				data[i][j] = linArr[count];
				count++;
			}
		}
	}
	
	
	// getter method for numRows
	public int getNumRows() {
		return numRows; 
	}
	
	// getter method for numCols
	public int getNumCols() {
		return numCols; 
	}
	
	// getter method for 2D array with matrix data
	public double[][] getData() {
		return data; 
	}
	
	// getter method for values in data 2D array 
	public double getElement(int r, int c) {
		return data[r][c];
	}

	
	// set and store value at r and c of data array
	public double setElement(int r, int c, double value) {
		return data[r][c] = value; 
	}
	
	
	// method of transposing the matrix and updating instance variables 
	public void transpose() {
		double[][] transposed = new double[numCols][numRows]; 
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				transposed[j][i] = this.data[i][j]; 
			}
		}

		int x = numRows; 
		this.data = transposed;   
		this.numRows = numCols; 
		numCols = x; 

	}
	
	
	// Matrix-Scalar multiplication 
	public Matrix multiply (double scalar) {
		// new Matrix using the same dimensions as 'this' matrix: 
		Matrix result = new Matrix(numRows, numCols);	
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				result.data[i][j] = data[i][j]*scalar; 
			}
		}
		return result; 
	}
	
	
	// Matrix-Matrix multiplication 
	public Matrix multiply (Matrix other) {
		//  if the number of columns of 'this' matrix and number of rows of 'other' matrix: return null
		if (numCols != other.numRows) { 
			return null; 
		}
		
		// new Matrix using the number of rows from 'this' and number of columns from 'other' matrix:
		Matrix result = new Matrix(numRows, other.numCols); 
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < other.numCols; j++) {
				for (int k = 0; k < numCols; k++) {
					result.data[i][j] += data[i][k]*other.data[k][j]; 
				}
			}
		}
		return result; 
	}
	
	
	// toString method to return a string containing the full matrix
	public String toString() {
		// if the matrix data array is empty: 
		if (data.length == 0) { 
			return "Empty matrix"; 
		} 
		
		else {
			StringBuilder sb = new StringBuilder(); 
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					sb.append(String.format("%8.3f", data[i][j]));
				}
				sb.append("\n");
			}
			return sb.toString(); 
		}
	}
}
