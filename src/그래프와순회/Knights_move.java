package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knights_move {
	static int[] dirc_x = {-2,-1,1,2};
	static int[] dirc_y = {-2,-1,1,2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test = 0 ; test < t ; test++) {
			int len = Integer.parseInt(br.readLine());
			int[][] arr = new int[len][len];
			for(int i = 0 ; i < len ; i++) Arrays.fill(arr[i], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_y = Integer.parseInt(st.nextToken());
			int start_x = Integer.parseInt(st.nextToken());
			arr[start_y][start_x] = 0;
			Queue<int[]> que = new LinkedList<int[]>();		// 0 : y, 1 : x
			que.offer(new int[] {start_y,start_x});
			while(!que.isEmpty()) {																// BFS 시작
				int[] temp = que.poll();
				for(int y = 0 ; y < 4 ; y++) {
					int temp_y = temp[0] + dirc_y[y];
					if(temp_y >= 0 && temp_y < len) {											// temp_y 범위 내에 있으면 x 변경
						for(int x = 0 ; x < 4 ; x++) {
							if(Math.abs(dirc_x[x]) != Math.abs(dirc_y[y])) {					// 대각선 ㄴㄴ
								int temp_x = temp[1] + dirc_x[x];
								if(temp_x >= 0 && temp_x < len) {
									if(arr[temp_y][temp_x] == -1) {								// temp_x 범위 내에 있으면 방문 확인
										arr[temp_y][temp_x] = arr[temp[0]][temp[1]] + 1;		// 있으면 이전에 왔던 횟수에 + 1
										que.offer(new int[] {temp_y,temp_x});
									}
								}
							}
						}
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			int end_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			sb.append(arr[end_y][end_x] + "\n");
		}
		System.out.println(sb);
	}

}
