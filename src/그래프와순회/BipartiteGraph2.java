package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BipartiteGraph2 {
	static HashSet<Integer>[] arr;
	static char[] chk;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr = new HashSet[v+1];
			chk = new char[v+1];
			for(int j = 1; j <= v ; j++) {
				arr[j] = new HashSet<>();
			}
			
			for(int j = 0 ; j < e ; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				arr[start].add(end);
				arr[end].add(start);
			}
			boolean tf = true;
			for(int j = 1 ; j <= v ; j++) {
				Queue<Integer> que = new LinkedList<Integer>();
				que.add(j);
				if(chk[j] == 0) chk[j] = 'r';
				while(!que.isEmpty()) {
					int temp = que.poll();
					for(int get : arr[temp]) {
						if(chk[get] == 0) {
							if(chk[temp] == 'r') chk[get] = 'b';
							else chk[get] = 'r';
							que.add(get);
						}
						else {
							if(chk[temp] == chk[get]) {
								tf = false;
								break ;
							}
						}
					}
				}
				if(!tf) break ;
			}
			
			if(tf) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}


	
}
