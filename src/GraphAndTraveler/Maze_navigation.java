package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_navigation {
	static boolean[][] arr;
	static int[] dirc_x = {1,0,0,-1};
	static int[] dirc_y = {0,-1,1,0};
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new boolean[n+2][m+2];
		int[][] cnt = new int[n+2][m+2];
		for(int i = 0 ; i < n+2; i++) Arrays.fill(cnt[i], 1);
		for(int i = 1 ; i <= n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				if('1' == str.charAt(j)) arr[i][j+1] = true;
			}
		}
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{1,1});
		while(!que.isEmpty()) {
			int x = que.peek()[1];
			int y = que.peek()[0];
			que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int temp_x = x + dirc_x[i];
				int temp_y = y + dirc_y[i];
				if(arr[temp_y][temp_x]) {
					arr[temp_y][temp_x] = false;
					cnt[temp_y][temp_x] += cnt[y][x];
					que.offer(new int[] {temp_y,temp_x});
				}
			}
		}
		System.out.println(cnt[n][m]);
		
	}

}
