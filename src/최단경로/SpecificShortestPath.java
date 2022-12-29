package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecificShortestPath {
	static int n;
	static HashSet<Node>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		arr = new HashSet[n+1];
		for(int i = 1 ; i <= n ; i++) arr[i] = new HashSet<>();
		
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Node(end, length));
			arr[end].add(new Node(start, length));
		}
		
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		find(1,2);
		int sum1 = 0;
		sum1 += find(1,u);
		sum1 += find(u,v);
		sum1 += find(v,n);
		int sum2 = 0;
		sum2 += find(1,v);
		sum2 += find(v,u);
		sum2 += find(u,n);
		
		System.out.println(Math.min(sum1, sum2));
	}

	private static int find(int start, int end) {
		int[] result = new int[n+1];
		
		Arrays.fill(result, 200000001);
		result[start] = 0;
		boolean[] chk = new boolean[n+1];
		PriorityQueue<Node> que = new PriorityQueue<>((o1,o2) -> o1.length - o2.length);
		que.add(new Node(start,0));
		while(!que.isEmpty()) {
			Node temp = que.poll();
			chk[temp.destination] = true;
			Iterator<Node> ir = arr[temp.destination].iterator();
			while(ir.hasNext()) {
				Node node = ir.next();
				if(!chk[node.destination] && result[temp.destination] + node.length < result[node.destination]) {
					result[node.destination] = result[temp.destination] + node.length;
					que.add(new Node(node.destination,result[node.destination]));
				}
			}
		}
		if(!chk[end]) {
			System.out.println(-1);
			System.exit(0);
		}
		return result[end];
	}

}

class Node{
	
	int destination;
	int length;
	Node(int destination, int length){
		this.destination = destination;
		this.length = length;
	}
}
