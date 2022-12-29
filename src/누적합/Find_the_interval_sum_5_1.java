package ������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_the_interval_sum_5_1 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		for(int i = 1 ; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1] + arr[i-1][j] - arr[i-1][j-1];
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			long result = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1-1][y1-1];
			System.out.println(result);
		}
		
	}

}
