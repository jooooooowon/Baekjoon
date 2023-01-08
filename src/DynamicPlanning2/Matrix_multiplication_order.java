package DynamicPlanning2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix_multiplication_order {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int[n + 1];
		int[][] dp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i + 1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 2; i < n + 1; i++) { // 구간 간격
			for(int j = 0; j + i < n + 1 ; j++) { // 시작점
				dp[j][j+i-1] = Integer.MAX_VALUE;
				for(int k = j; k < j + i - 1; k++) {
					int val = dp[j][k] + dp[k+1][j + i -1] + (arr[j] * arr[k + 1] * arr[j+i]);
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], val);
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}

}
