package ShortestRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Duo2{
	int destination;
	int cost;
	public Duo2(int destination, int cost) {
		this.destination = destination;
		this.cost = cost;
	}
}

public class UnconfirmedDestination2 {
	static HashSet<Duo2>[] arr;
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
				
				d *= 2;
				arr[a].add(new Duo2(b,d));
				arr[b].add(new Duo2(a,d));
			}
			int need = 0;
			Iterator<Duo2> ir = arr[g].iterator();
			while(ir.hasNext()) {
				Duo2 temp = ir.next();
				if(temp.destination == h) {
					arr[g].remove(temp);
					arr[g].add(new Duo2(temp.destination, temp.cost - 1));
					break ;
				}
			}
			ir = arr[h].iterator();
			while(ir.hasNext()) {
				Duo2 temp = ir.next();
				if(temp.destination == g) {
					arr[h].remove(temp);
					arr[h].add(new Duo2(temp.destination, temp.cost - 1));
					break ;
				}
			}
			
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int idx = 0; idx < t; idx++) {
				int temp = Integer.parseInt(br.readLine());
				int shortest = find(s,temp);
				if(shortest % 2 == 1) que.add(temp);
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
		
		PriorityQueue<Duo2> que = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
		que.add(new Duo2(s,0));
		chk[s] = true;
		while(!que.isEmpty()) {
			Duo2 temp = que.poll();
			for(Duo2 duo : arr[temp.destination]) {
				if(!chk[duo.destination] || count[duo.destination] > count[temp.destination] + duo.cost) {
					count[duo.destination] = count[temp.destination] + duo.cost;
					chk[duo.destination] = true;
					que.add(new Duo2(duo.destination,count[duo.destination]));
				}
			}
		}
		return count[g];
	}

}
