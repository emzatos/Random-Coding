import java.util.*;

public class Mult{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();

		for(int i=1; i<=x; i++){
			for(int j = 1; j<=y; j++){
				num.add(i*j);
			}
		}
		Collections.sort(num);
		System.out.println(num.get(k-1));
	}
}