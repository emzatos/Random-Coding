import java.util.HashMap;
import java.util.TreeMap;
public class Collatz{
	static HashMap<Long, Long> coll = new HashMap<Long, Long>();
	public static long col(long n){
		long steps = 0;
		while(n != 1){
			if(n%2 == 0){
				n/=2;
				steps++;
			}else{
				n = (3*n+1)/2;
				steps+=2;
			}
		}

		return steps;
	}

	public static long longCol(long n){
		long steps = 0;
		long num = 0;
		for(long i=1; i<=n; i++){
			long temp = col(i);

			if(temp >= steps){
				steps = temp;
				num = i;
			}
			if(!coll.containsValue(num))
				coll.put(i, num);
		}

		return num;
	}

	public static void main(String[] args) {

		longCol(5000000);
		System.out.println(coll);
	}
}