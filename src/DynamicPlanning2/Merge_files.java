package DynamicPlanning2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_files {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int k;
		int[][] dp;
		for(int i = 0 ; i < t ; i++) {
			k = Integer.parseInt(br.readLine());
			int[] arr = new int[k + 1];
			int[] temp = new int[k + 1];
			int[] sum = new int[k + 1];
			dp = new int[k + 1][k + 1];
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= k ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + arr[j];
			}
			for(int n = 1 ; n <= k ; n++) {
				for(int from = 1; from + n <= k ; from++) {
					int to = from + n;
					dp[from][to] = Integer.MAX_VALUE;
					for(int div = from; div < to; div++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][div] + dp[div + 1][to] + sum[to] - sum[from - 1]);
					}
				}
			}

			System.out.println(dp[1][k]);
		}
	}

}
