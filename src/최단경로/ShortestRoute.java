package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ShortestRoute {
	static HashSet<int[]>[] arr; 
	static int[] result;
	static boolean[] chk;
	static int v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		result = new int[v+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[k] = 0;
		chk = new boolean[v+1];
		
		arr = new HashSet[v+1];
		for(int i = 1; i <= v; i++) arr[i] = new HashSet<>();
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[start].add(new int[] {end,value});
		}

		find(k);
		for(int i = 1; i <= v; i++) {
			if(!chk[i])System.out.println("INF");
			else System.out.println(result[i]);
		}
			
	}

	private static void find(int k) {
		chk[k] = true;
		Iterator<int[]> ir = arr[k].iterator();
		while(ir.hasNext()) {
			int[] temp = ir.next();
			int idx = temp[0];
			int value = temp[1];
			
			result[idx] = Math.min(result[idx], result[k]+value);
		}
		int min = Integer.MAX_VALUE;
		int idx = v+1;
		for(int i = 1; i <= v ; i++) {
			if(!chk[i] && min > result[i] && result[i] != 0) {
				min = result[i];
				idx = i;
			}
		}
		if(idx == v+1) return;
		find(idx);
	}

}
