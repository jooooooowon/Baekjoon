package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snakes_and_ladders_game {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] count = new int[101];
		int[] ladder = new int[101];
		int[] snake = new int[101];
		boolean[] chk = new boolean[101];
		chk[0] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int temp_from = Integer.parseInt(st.nextToken());
			int temp_to = Integer.parseInt(st.nextToken());
			ladder[temp_from] = temp_to;
		}
	
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int temp_from = Integer.parseInt(st.nextToken());
			int temp_to = Integer.parseInt(st.nextToken());
			snake[temp_from] = temp_to;
		}
		
		que.add(1);
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i = 1 ; i <= 6 ; i++) {
				int temp_move = temp + i;
				if(temp_move <= 100 && !chk[temp_move]) {
					chk[temp_move] = true;
					if(ladder[temp_move] == 0 && snake[temp_move] == 0) {
						que.add(temp_move);
						count[temp_move] += count[temp] + 1;
					}
					else if(ladder[temp_move] != 0){
						if(!chk[ladder[temp_move]]) {
							chk[ladder[temp_move]] = true;
							que.add(ladder[temp_move]);
							count[ladder[temp_move]] += count[temp] + 1;
						}
					}
					else {
						if(!chk[snake[temp_move]]) {
							chk[snake[temp_move]] = true;
							que.add(snake[temp_move]);
							count[snake[temp_move]] += count[temp] + 1;
						}
					}
				}
			}
		}
		System.out.println(count[100]);
		
	}

}
