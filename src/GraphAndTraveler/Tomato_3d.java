package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_3d {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[z][y][x];
		int[][][] count = new int[z][y][x];
		boolean[][][] dp = new boolean[z][y][x];
		
		Queue<int[]> que = new LinkedList<int[]>();
		for(int k = 0 ; k < z ; k++) {
			for(int i = 0 ; i < y ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < x ; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());		
					if(arr[k][i][j] == 1) {
						dp[k][i][j] = true;
						que.add(new int[] {k,i,j});					// (z,y,x)
					}
				}
			}
		}
		
		int[] dir_x = {1,-1,0,0,0,0};
		int[] dir_y = {0,0,1,-1,0,0};
		int[] dir_z = {0,0,0,0,1,-1};
		
		while(!que.isEmpty()) {
			int[] temp_arr = que.poll();
			
			for(int i = 0 ; i < 6 ; i++) {
				int temp_z = temp_arr[0] + dir_z[i];
				int temp_y = temp_arr[1] + dir_y[i];
				int temp_x = temp_arr[2] + dir_x[i];
				
				if(temp_z >= 0 && temp_z < z && temp_y >= 0 && temp_y < y && temp_x >= 0 && temp_x < x 
						&& !dp[temp_z][temp_y][temp_x] && arr[temp_z][temp_y][temp_x] != -1) {
					que.add(new int[] {temp_z,temp_y,temp_x});
					dp[temp_z][temp_y][temp_x] = true;
					count[temp_z][temp_y][temp_x] += count[temp_arr[0]][temp_arr[1]][temp_arr[2]] + 1;
				}
			}
		}
		
		int max = 0;
		for(int k = 0 ; k < z ; k++) {
			for(int i = 0 ; i < y ; i++) {
				for(int j = 0 ; j < x ; j++) {
					if(!dp[k][i][j] && arr[k][i][j] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
					max = Math.max(max, count[k][i][j]);
				}
			}
		}
		System.out.println(max);
		
	}

}
