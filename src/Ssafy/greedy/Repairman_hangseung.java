package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Repairman_hangseung {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			pque.offer(Integer.parseInt(st.nextToken()));
		}
		int count = 0;
		while(!pque.isEmpty()) {
			int start = pque.poll();
			if(!pque.isEmpty()) {
				int temp = pque.poll();
				boolean tf = false;
				while(temp - start + 1 <= l) {
					if (pque.isEmpty()) {
						tf =true;
						break ;
					}
					else temp = pque.poll();
				}
				if(!tf)pque.offer(temp);
			}
			count++;
		}
		System.out.println(count);
		
	}

}
