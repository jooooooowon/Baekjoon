package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algorithm_Lesson_DFS_1 {
	static boolean[] tf;
	static int[] arr;
	static int count = 0;
	static ArrayList<Integer>[] list; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		tf = new boolean[n+1];
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) list[i] = new ArrayList<>();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i = 1 ; i <= n ; i++) {
			Collections.sort(list[i]);
		}
		dfs(r);
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= n ; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r) {
		tf[r] = true;
		count++;
		arr[r] = count;
		for(int i : list[r]) {
			if(!tf[i]) dfs(i);
		}
		
	}

}
