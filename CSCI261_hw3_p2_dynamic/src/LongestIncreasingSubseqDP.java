/**
 * LongestIncreasingSubswqDP.java
 * 
 * @author	Derek Brown <djb3718@rit.edu>
 * 
 * purpose	A dynamic programming implementation for finding the longest 
 * 		subsequence of increasing numbers in an array.
 */

import java.util.Scanner;

public class LongestIncreasingSubseqDP {
	
	// Attributes
	
	private int[] sequence;
	private int[] solution;
	
	// Constructor
	
	/**
	 * Constructor for creating a LongestIncreasingSubseqDP instance
	 * 
	 * @param values	The array of values read in from user
	 * @param size		The number of elements in the initial array
	 */
	public LongestIncreasingSubseqDP( int[] values, int size ) {
		this.sequence = values;
		this.solution = new int[size];
	}//end LongestIncreasingSubseqDP constructor

	/**
	 * Reads in the data from the user and runs the dynamic programming
	 * algorithm on the data, The algorithm finds the length of the longest
	 * subsequence of increasing values and displays it to the user.
	 * 
	 * @param args	Command line arguments.  Unused.
	 */
	public static void main(String[] args) {
		
		// Read in the values
		Scanner sc = new Scanner( System.in );
		String input = sc.next();
		int size = Integer.parseInt(input);
		int[] values = new int[size];
		for( int i = 0 ; i < size ; i++ ) {
			input = sc.next();
			int value = Integer.parseInt(input);
			values[i] = value;
		}//end for
		LongestIncreasingSubseqDP DP =
			new LongestIncreasingSubseqDP( values, size);
		
		// Algorithm
		for( int j = 0 ; j < size ; j++ ) {
			DP.solution[j] = 1;
			for( int k = 0 ; k < j ; k++ ) {
				if( ( DP.sequence[k] < DP.sequence[j] ) &&
					(DP.solution[j] < DP.solution[k]+1 ) ) {
					DP.solution[j] = DP.solution[k]+1;
				}//end if
			}//end for
		}//end for
		
		// Retrieve max
		int max = 0;
		for( int value : DP.solution ) {
			if( value > max ) {
				max = value;
			}//end if
		}//end for
		System.out.println(max);
		sc.close();
	}//end main
}//end LongestIncreasingSubseqDP
