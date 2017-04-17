import java.util.*;
import java.io.*;

public class Greg{

	public static class Op{
		int l, r, d;
		public Op(int l, int r, int d){
			this.l = l;
			this.r = r;
			this.d = d;
		}
	}

	public static int[] apply(Op op, int[] arr){
		for(int i=op.l; i<op.r; i++){
			arr[i]+=op.d;
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int ops = sc.nextInt();
		int queries = sc.nextInt();
		ArrayList<Op> op_arr = new ArrayList<Op>();

		int[] arr = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		for(int i=0; i<ops; i++)
			op_arr.add(new Op(sc.nextInt()-1, sc.nextInt(), sc.nextInt()));
		

		for(int i=0; i<queries; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();

			for(int j=l-1; j<r; j++){
				arr = apply(op_arr.get(j), arr);
			}
		}

	//	System.out.println(Arrays.toString(arr));

		for(int i=0; i<arr.length; i++){
			if(i == arr.length-1)
				System.out.println(arr[i]);
			else System.out.print(arr[i] + " ");
		}
	}
}