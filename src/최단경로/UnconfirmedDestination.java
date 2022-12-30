package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Duo{
	int destination;
	int cost;
	public Duo(int destination, int cost) {
		this.destination = destination;
		this.cost = cost;
	}
}

public class UnconfirmedDestination {
	static HashSet<Duo>[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//9370
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase = 0 ; testcase < test ; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			arr = new HashSet[n+1];
			for(int idx = 1 ; idx < n+1; idx++) arr[idx] = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			
			for(int idx = 0; idx < m; idx++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				arr[a].add(new Duo(b,d));
				arr[b].add(new Duo(a,d));
			}
			int need = 0;
			Iterator<Duo> ir = arr[g].iterator();
			while(ir.hasNext()) {
				Duo temp = ir.next();
				if(temp.destination == h) {
					need = temp.cost;
					break ;
				}
			}
			
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int idx = 0; idx < t; idx++) {
				int temp = Integer.parseInt(br.readLine());
				int shortest = find(s,temp);
				int sum1 = 0;
				sum1 += find(s,g);
				sum1 += need;
				sum1 += find(h,temp);
				int sum2 = 0;
				sum2 += find(s,h);
				sum2 += need;
				sum2 += find(g,temp);
				
				int sumTemp = Math.min(sum1, sum2);
				if(sumTemp == shortest) que.add(temp);
			}
			while(!que.isEmpty()) {
				sb.append(que.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int find(int s, int g) {
		boolean[] chk = new boolean[n+1];
		int[] count = new int[n+1];
		
		PriorityQueue<Duo> que = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
		que.add(new Duo(s,0));
		chk[s] = true;
		while(!que.isEmpty()) {
			Duo temp = que.poll();
			for(Duo duo : arr[temp.destination]) {
				if(!chk[duo.destination] || count[duo.destination] > count[temp.destination] + duo.cost) {
					count[duo.destination] = count[temp.destination] + duo.cost;
					chk[duo.destination] = true;
					que.add(new Duo(duo.destination,count[duo.destination]));
				}
			}
		}
		return count[g];
	}

}
