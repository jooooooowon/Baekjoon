package Ssafy.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_silver2 {
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[n+1];
		arr = new int[n+1];
		for(int i = 1 ;  i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 1; i<=n ; i++) {
			for(int j = i ; j >= 0 ; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + arr[i],dp[i]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}


}
