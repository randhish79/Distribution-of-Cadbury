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
