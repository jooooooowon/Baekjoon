package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Organic_cabbage {
	static boolean[][] arr;
	static int[] dirc_x = {1,-1,0,0};
	static int[] dirc_y = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test = 0 ; test < t ; test++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());	//가로
			int n = Integer.parseInt(st.nextToken());	//세로	
			int k = Integer.parseInt(st.nextToken());
			arr = new boolean[n+2][m+2];
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y+1][x+1] = true;
			}
			int count = 0;
			for(int i = 1; i <= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					if(arr[i][j]) {
						count++;
						find(i,j);
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	private static void find(int y, int x) {
		arr[y][x] = false;
		for(int i = 0 ; i < 4 ; i++) {
			int temp_x = x + dirc_x[i];
			int temp_y = y + dirc_y[i];
			if(arr[temp_y][temp_x]) find(temp_y,temp_x);
		}
	}

}
