package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] count = new int[n][m];
		boolean[][] dp = new boolean[n][m];
		Queue<int[]> que = new LinkedList<int[]>();						// (y,x)
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					dp[i][j] = true;
					que.add(new int[] {i,j});
				}
			}
		}
		
		int[] dir_x = {1,-1,0,0};
		int[] dir_y = {0,0,1,-1};
		while(!que.isEmpty()) {
			
			int[] temp_arr = que.poll();
			for(int i = 0 ; i < 4; i++) {
				int temp_x = dir_x[i] + temp_arr[1];
				int temp_y = dir_y[i] + temp_arr[0];
				if(temp_x >= 0 && temp_x < m && temp_y >= 0 && temp_y < n && !dp[temp_y][temp_x] && arr[temp_y][temp_x] != -1) {
					que.add(new int[] {temp_y,temp_x});
					dp[temp_y][temp_x] = true;
					count[temp_y][temp_x] += count[temp_arr[0]][temp_arr[1]] + 1;
				}
				
			}
		}
		int max = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				if(!dp[i][j] && arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				max = Math.max(max, count[i][j]);
			}
		}
		System.out.println(max);
		
	}

}
