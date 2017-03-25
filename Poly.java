import java.util.*;
import java.io.*;

// Solution uses binary search for range between 1 and goal

// Runs in O(m*log(n)) where m is the length of the coefficient array and n is the length of the range 1 to goal

public class Poly{

	public static long calculate(long x, long[] coeff){


		long currentVal = 0;

		for(int i=0; i<coeff.length; i++){
			currentVal += (Math.pow(x,i)*coeff[i]);
		}

		return currentVal;
		
	}

	public static long bin_search(long[] coeff, long goal){
		long low = 1;
		long high = 1;

		if(calculate(high, coeff) == goal)
			return high;

		while(calculate(high, coeff) < goal){
			high*=2;
			low*=2;
		}

		low/=2;

		while(low + 1 < high){
			long mid = (low + high)/2;

			long temp =  calculate(mid, coeff);
			if(temp == goal){
				return mid;
			}

			if(temp < goal){
				low = mid;
			}

			if(temp > goal){
				high = mid;
			}
		}

		return -1;
	}








public static void main(String[] args) throws Exception{
	Scanner sc = new Scanner(System.in);
	long T = sc.nextLong();
	for(long t=0; t<T; t++){

		int order = sc.nextInt();
		long goal = sc.nextLong();



		long[] coeff = new long[order+1];
		for(int i=0; i<coeff.length; i++){
			coeff[i] = sc.nextLong();
		}

		if(goal == 0 && order > 0 && coeff[0] == 0){
			System.out.println(0);
			continue;
		}

		long solution = bin_search(coeff, goal);


		if(solution == -1)
			System.out.println("N/A");
		else System.out.println(solution);


	}
}

}