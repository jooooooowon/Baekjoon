package 우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABS_heap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(que.isEmpty()) sb.append(0 + "\n");
				else sb.append(que.poll() + "\n");
			}
			else que.add(x);
		}
		System.out.println(sb);
	}

}
