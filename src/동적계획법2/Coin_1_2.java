package µ¿Àû°èÈ¹¹ý2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin_1_2 {
	static int[] arr;
	static int[][] dp;
	static int n;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		dp = new int[n+1][k+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = 1; i <= n ; i++) {
			dp[i][0] = 1;
		}
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= k ; j++) {
				if(arr[i] <= j) {
					dp[i][j] = dp[i-1][j] + dp[i][j - arr[i]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
		
	}
	

}
