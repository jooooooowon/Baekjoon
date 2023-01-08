package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BipartiteGraph {
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
			boolean tf = true;
			for(int j = 0 ; j < e ; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(arr[start] == null) {
					arr[start] = new HashSet<>();
				}
				arr[start].add(end);
			}
			for(int j = 1 ; j <= v ; j++) {
				if(chk[j] == 0) tf = find(j,'r');
				else tf = true;
				if(!tf) break;
			}
			if(tf) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}

	private static boolean find(int idx, char color) {
		chk[idx] = color;
		boolean tf = true;
		if(arr[idx] == null) return true;
		Iterator<Integer> ir = arr[idx].iterator();
		while(ir.hasNext()) {
			int next = ir.next();
			if(chk[next] == 0) {
				if(color == 'r') tf = find(next,'b');
				else tf = find(next,'r');
			}
			else {
				if(chk[next] == color) {
					return tf = false;
				}
			}
			if(!tf) break;
		}
		return tf;
	}

}
