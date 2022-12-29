package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus_DFS {
	static ArrayList<Integer>[] list;
	static boolean[] tf;
	static int count = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[num+1];
		tf = new boolean[num+1];
		for(int i = 1 ; i <= num ; i++) list[i] = new ArrayList<>();
			
		for(int i = 1 ; i <= n ; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		dfs(1);
		System.out.println(count);
	}
	private static void dfs(int root) {
		count++;
		tf[root] = true;
		for(int i : list[root]) {
			if(!tf[i]) dfs(i);
		}
	}

}
