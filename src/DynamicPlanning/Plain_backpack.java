package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Plain_backpack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] temp = new int[n + 1][k + 1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());	// 무게
			v[i] = Integer.parseInt(st.nextToken());	// 가치
		}
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= k; j++) {
				if(w[i] > j) {
					temp[i][j] = temp[i - 1][j];
				}
				else {
					temp[i][j] = Math.max(temp[i - 1][j], v[i] + temp[i - 1][j - w[i]]);
				}
			}
		}
		
		System.out.println(temp[n][k]);
	}

}
