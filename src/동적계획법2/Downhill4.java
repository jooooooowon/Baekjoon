package µ¿Àû°èÈ¹¹ý2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Downhill4 {
	static int[][] arr;
	static int[][] dp;
	static int[] temp_j = {0,0,1,-1};
	static int[] temp_i = {1,-1,0,0};
	static int m;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		dp = new int[m][n];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				dp[i][j] = -1;
			}
		}
		int result = fnd(0,0);
		System.out.println(result);
	}
	private static int fnd(int i, int j) {
		if(i == m - 1 && j == n - 1) return 1;
		if(dp[i][j] != -1) return dp[i][j];
		dp[i][j] = 0;
		for(int idx = 0 ; idx < 4 ; idx++) {
			int x = temp_i[idx] + i;
			int y = temp_j[idx] + j;
			if(x >= 0 && x < m && y >= 0 && y < n) {
				if(arr[i][j] > arr[x][y]) {
					dp[i][j] += fnd(x,y);
				}
			}
		}
		
		return dp[i][j];
	}

}
