package DynamicPlanning2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pelindrome2 {
	static int[][] dp;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				dp[i][j] = -1;
			}
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int result = pelindrome(start,end);
			sb.append(result + "\n");
		}
		System.out.println(sb);
		
	}
	private static int pelindrome(int start, int end) {
		if(start == end) return dp[start][end] = 1;
		else if(end == start + 1) {
			if(arr[start] == arr[end]) return dp[start][end] = 1;
			else return dp[start][end] = 0;
		}
		
		if (dp[start][end] != -1) return dp[start][end];
		
		else {
			if(pelindrome(start + 1, end - 1) == 1 && arr[start] == arr[end]) return dp[start][end] = 1;
			else return dp[start][end] = 0;
		}		
	}

}
