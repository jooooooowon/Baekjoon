package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Put_a_number_on_complex {
	static int[] dir_x = {1,-1,0,0};
	static int[] dir_y = {0,0,1,-1,};
	static boolean[][] tf;
	static int[][] ans;
	static int count ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+2][n+2];
		ans = new int[n+2][n+2];
		tf = new boolean[n+2][n+2];
		for(int i = 1 ; i <= n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				arr[i][j+1] = Character.getNumericValue(str.charAt(j));
				if(arr[i][j+1] == 1) tf[i][j+1] = true;
			}
		}
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(tf[i][j]) {
					count = 0;
					find(i,j);
					que.offer(count);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(que.size()+"\n");
		while(!que.isEmpty()) {
			sb.append(que.poll()+"\n");
		}
		System.out.println(sb);
	}
	

	private static void find(int y, int x) {
		tf[y][x] = false;
		count++;
		for(int i = 0 ; i < 4 ; i++) {
			int temp_x = x+dir_x[i];
			int temp_y = y+dir_y[i];
			if(tf[temp_y][temp_x]) find(temp_y,temp_x);
		}
	}

}
