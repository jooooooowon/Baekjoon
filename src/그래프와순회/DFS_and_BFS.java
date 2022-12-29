package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_and_BFS {
	static ArrayList<Integer>[] list ;
	static boolean[] tf;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int v =Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		tf = new boolean[n+1];
		for(int i = 1 ; i <= n ; i ++) list[i] = new ArrayList<>();
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list[first].add(second);
			list[second].add(first);
		}
		for(int i = 1 ; i <= n ; i++) Collections.sort(list[i]);
		dfs(v);
		sb.append("\n");
		tf = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	private static void dfs(int v) {
		sb.append(v+" ");
		tf[v] = true;
		for(int i : list[v]) {
			if(!tf[i]) dfs(i);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(v);
		tf[v] = true;
		sb.append(v+" ");
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i : list[temp]) {
				if(!tf[i]) {
					tf[i] = true;
					sb.append(i+" ");
					que.offer(i);
				}
			}
		}
		
	}
}
