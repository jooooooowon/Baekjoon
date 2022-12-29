package Ssafy.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i < test; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for(int row = 0 ; row < 2 ; row++) {
				st = new StringTokenizer(br.readLine());
				for(int column = 1 ; column <= n ; column++) {
					arr[row][column] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			int max = 0;
			for(int column = 1 ; column <= n ; column++) {
				for(int row = 0 ; row < 2; row++) {
					for(int temp_row = 0; temp_row < 2; temp_row++) {
						if(temp_row == row) {
							for(int temp_column = 0 ; temp_column < column - 1; temp_column++) {
								dp[row][column] = Math.max(dp[row][column], dp[temp_row][temp_column] + arr[row][column]);
							}
						}
						else {
							for(int temp_column = 0 ; temp_column < column; temp_column++) {
								dp[row][column] = Math.max(dp[row][column], dp[temp_row][temp_column] + arr[row][column]);
							}
						}
						max = Math.max(max, dp[row][column]);
					}
				}
			}
			System.out.println(max);
		}
	}

}
