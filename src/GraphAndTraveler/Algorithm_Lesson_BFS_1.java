package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algorithm_Lesson_BFS_1 {
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());		
		int m =Integer.parseInt(st.nextToken());		
		int r =Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		int[] visit = new int[n+1];
		for(int i = 0 ; i <= n ; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u =Integer.parseInt(st.nextToken());
			int v =Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i = 0 ; i <= n ; i++) Collections.sort(list[i]);
		
		Queue<Integer> que = new LinkedList<Integer>();
		int count = 1;
		que.offer(r);
		visit[r] = count;
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i : list[temp]) {
				if(visit[i] == 0) {
					count++;
					visit[i] = count;
					que.offer(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= n ; i++) sb.append(visit[i]+"\n");
		System.out.println(sb);
		
	
	}

}
