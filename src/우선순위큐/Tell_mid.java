package 우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tell_mid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		PriorityQueue<Integer> que_r = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if(que_r.isEmpty()) que_r.add(x);
			else if(que_r.peek() >= x) que_r.add(x);
			else que.add(x);
			int size = que.size();
			int size_r = que_r.size();
			if(size + 1 < size_r) que.add(que_r.poll());
			else if(size > size_r) que_r.add(que.poll());
			sb.append(que_r.peek() + "\n");
		}
		System.out.println(sb);
	}

}
