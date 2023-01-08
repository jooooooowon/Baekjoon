package PriorityQue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Max_heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(que.isEmpty()) sb.append(0 + "\n");
				else sb.append(que.poll()).append("\n");
			}
			else {
				que.add(x);
			}
		}
		System.out.println(sb);
	}
}

