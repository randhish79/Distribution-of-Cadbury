/* Input :-   4 Integers will be provieded as input 
		Test Input :  5 6 3 4 
		First 2 integers are given length of possible rectangles 
      	
 		Possible rectangles that can be formed from input : --     5 x 3 ,  5x4,   6 x3, 6x4 
		
		You have to find out maximum perfect squares that can be formed from these rectangular chocolates.
		Example : -   For :  5 x3 rectangle   Possible perfect squares would be : - 3x3 
											    2x2
											    1x1
											    1x1
	`			So, Chocolates can be given to 4 children
			Similarly, For :  6 x3 rectangle   Possible perfect squares would be : - 3x3 
											   	 3x3
				So, Chocolates can be given to 2 children
				
Objective : You have to caluclate the number of children which can be given perfect square chocolates 
            from given length and breadth of rectangle of chocolates. 
											   

 
*/
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class CandidateCode {
	static int count = 0;

	static void possibleSqaures(int length, int breadth) {
		if (length > 0 && breadth > 0) {
			if (length == 1 || breadth == 1) {
				int max = Math.max(length, breadth);
				count = count + max;
				return;
			} else {
				if (length > 1 && breadth > 1 && length == breadth) {
					count++;
					return;
				}
				int min = Math.min(length, breadth);
				if (length > min) {
					count++;
					possibleSqaures(length - min, breadth);
				} else if (breadth > min) {
					count++;
					possibleSqaures(length, breadth - min);
				}

			}
		} else {
			return;
		}
	}
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);// Write code here
		int[] dimensionsOfGivenRecantagle = new int[4];
		for (int i = 0; i < 4; i++) {
			dimensionsOfGivenRecantagle[i] = sc.nextInt();
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 2; j < 4; j++) {
				possibleSqaures(dimensionsOfGivenRecantagle[i], dimensionsOfGivenRecantagle[j]);
			}
		}
		System.out.println(count);

	}
}
