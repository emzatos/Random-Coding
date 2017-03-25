import java.util.*;
import java.io.*;

public class Cola{

	public static long bin(long coins, long[] shops){
		
		if(shops[shops.length-1] <= coins)
			return shops.length;

		int pos = Arrays.binarySearch(shops, coins);

		if(pos > 0 && pos < shops.length-1 && shops[pos] == coins && shops[pos+1] == coins){
			while(pos < shops.length && shops[pos] == coins){
				pos++;
			}

			return pos;
		}

		if(pos < 0){
			return -pos -1;
		}

		if(shops[pos] == coins)
			return pos+1;

		return pos;


	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		OutputStream out = new BufferedOutputStream(System.out);
		int shops = sc.nextInt();
		long[] nums = new long[shops];

		
		for(int i=0; i< shops; i++)
			nums[i] = sc.nextLong();



		Arrays.sort(nums);


		Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums));
		boolean val = set.size() == 1;

		long numDays = sc.nextLong();
		for(long i=0 ; i<numDays; i++){

			if(!val){
				long result = bin(sc.nextLong(), nums);
				out.write((result+"\n").getBytes());
			}else{
				long temp = sc.nextLong();
				if(temp >= set.iterator().next())
					out.write((shops+"\n").getBytes());
				else
					out.write(("0\n").getBytes());
			}
			
		}
		out.flush();
	}
}