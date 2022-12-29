package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Go_down {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][5];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[n][5];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		dp[0][3] = arr[0][3];
		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j <= 3 ; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j+1], dp[i-1][j-1]), dp[i-1][j]) + arr[i][j];
			}
		}
		
		sb.append(Math.max(Math.max(dp[n-1][1],dp[n-1][2]),dp[n-1][3]) + " ");
		dp = new int[n][5];
		for(int i = 0 ; i < n ; i++) {
			Arrays.fill(dp[i], 1000000);
		}
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		dp[0][3] = arr[0][3];
		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j <= 3 ; j++) {
				dp[i][j] = Math.min(Math.min(dp[i-1][j+1], dp[i-1][j-1]), dp[i-1][j]) + arr[i][j];
			}
		}
		sb.append(Math.min(Math.min(dp[n-1][1],dp[n-1][2]),dp[n-1][3]));
		System.out.println(sb);
		
		
	}

}
