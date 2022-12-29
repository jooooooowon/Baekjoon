package ДЉРћЧе;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_the_interval_sum_5 {
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
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1];
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			long result = 0;
			for(int j = x1; j <= x2; j++) {
				result += arr[j][y2] - arr[j][y1 - 1];
			}
			System.out.println(result);
		}
		
	}

}
