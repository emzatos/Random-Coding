import java.util.*;
import java.io.*;

public class ps8{

	public static class Jewel{
		int weight;
		int value;

		public Jewel(int value, int weight){
			this.weight = weight;
			this.value = value;
		}

	}

	public static int all(List<Jewel> jewels, int maxCapacity) {
		int[] bestValue = new int[maxCapacity + 1];
		bestValue[0] = 0;
		for (int cap = 1; cap <= maxCapacity; cap++){
			Collections.sort(jewels, (a, b) -> {
				return Integer.compare(
					a.value * b.weight,
					b.value * a.weight
					); });
			Collections.reverse(jewels);
			for (Jewel jewel : jewels)
				if (jewel.weight <= cap)
					bestValue[cap] = Math.max(
						bestValue[cap],
						jewel.value +
						bestValue[cap - jewel.weight]
						)*jewel.value/jewel.weight;
			}
			return bestValue[maxCapacity];
		}
		public static int infKnapsack(List<Jewel> jewels, int maxCapacity) {
			int[] bestValue = new int[maxCapacity + 1];
			bestValue[0] = 0;
			for (int cap = 1; cap <= maxCapacity; cap++){

				for (Jewel jewel : jewels)
					if (jewel.weight <= cap)
						bestValue[cap] = Math.max(
							bestValue[cap],
							jewel.value +
							bestValue[cap - jewel.weight]
							);
				}
				return bestValue[maxCapacity];
			}

			public static double fractionalKnapsack(List<Jewel> jewels,
				double capacity) {
				Collections.sort(jewels, (a, b) -> {
					return Integer.compare(
						a.value * b.weight,
						b.value * a.weight
						); });
				Collections.reverse(jewels);
				double value = 0.0;
				for (Jewel jewel : jewels) {
					double taken = Math.min(capacity, jewel.weight);
					capacity -= taken;
					value += taken * jewel.value / jewel.weight;
				}
				return value;
			}

			public static int knapsack(List<Jewel> jewels, int maxCapacity) {
				int n = jewels.size();
				int[][] bestValue = new int[n][maxCapacity + 1];
				for (int cap = 1; cap <= maxCapacity; cap++){
					for (int i = 1; i < n; i++){
						Jewel jewel = jewels.get(i - 1);

						bestValue[i][cap] = bestValue[i - 1][cap];
						if (jewel.weight <= cap)
							bestValue[i][cap] = Math.max(
								bestValue[i][cap],
								jewel.value +
								bestValue[i - 1][cap - jewel.weight]
								);
					}
				}

				return bestValue[n-1][maxCapacity];
			}

			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				int cases = sc.nextInt();
				for(int t=0; t<cases; t++){
					int nums = sc.nextInt();
					int maxCapacity = sc.nextInt();
					ArrayList<Jewel> jewels = new ArrayList<Jewel>();
					for(int i=0; i<nums; i++)
						jewels.add(new Jewel(sc.nextInt(), sc.nextInt()));

					System.out.println(fractionalKnapsack(jewels, maxCapacity));
					System.out.println(infKnapsack(jewels, maxCapacity));
					System.out.println(knapsack(jewels, maxCapacity));
					System.out.println(all(jewels, maxCapacity));

				}
			}
		}