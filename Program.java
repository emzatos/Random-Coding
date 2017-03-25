import java.util.*;
public class Program{
	
	public static int calculate(int v, int k){
		int total = 0;
		int current = v;
		while(current != 0){
			total+=current;
			current/=k;
			System.out.println(current);
		}

		return total;
	}

	public static int bin(int n, int k){
		int low = 1;
		int high = n;
		int mid = (low+high)/2;
		int temp = calculate(mid, k);

		while(low+1 < high && temp < n){
			if(temp < n){
				low = mid;
			}
			if(temp > n){
				high = mid;
			}

			mid = (low+high)/2;
			temp = calculate(mid,k);
		}

		return mid;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(bin(n,k));

	}
}