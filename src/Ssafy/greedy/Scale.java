package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Scale {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		int sum = 1;
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(temp <= sum) sum += temp;
			else break;
		}
		System.out.println(sum);
	}

}
