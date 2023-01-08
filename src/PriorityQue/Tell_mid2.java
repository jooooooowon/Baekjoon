package PriorityQue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tell_mid2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		PriorityQueue<Integer> que_r = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if(i % 2 == 0) que_r.add(x);
			else que.add(x);
			
			if(!que_r.isEmpty() && !que.isEmpty()) {
				if(que_r.peek() > que.peek()) {
					que.add(que_r.poll());
					que_r.add(que.poll());
				}
			}
			sb.append(que_r.peek()).append("\n");
		}
		System.out.println(sb);
	}

}
