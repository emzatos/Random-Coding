import java.util.*;
import java.io.*;

public class Subseq{

	public static int[] 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrsize = sc.nextInt();
		int[] arr = new int[arrsize];
		for(int i=0; i<arrsize; i++){
			arr[i] = sc.nextInt();
		}

		int[] min_arr = new int[arrsize];
		for(int i=0; i<arrsize; i++){
			int count = 0;
			for(int j=0; j < i; j++){
				if(arr[j] < arr[i]){
					count++;
				}
			}
		}
	}
}