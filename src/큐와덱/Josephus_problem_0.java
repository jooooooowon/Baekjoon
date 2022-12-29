package Å¥¿Íµ¦;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus_problem_0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for(int i = 1 ; i <= n; i++) {
			que.offer(i);
		}
		while(!que.isEmpty()) {
			for(int i = 0; i < k - 1; i++) {
				que.offer(que.poll());
			}
			result.offer(que.poll());
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(result.size() > 1) {
			sb.append(result.poll()).append(", ");
		}
		sb.append(result.poll()).append(">");
		System.out.println(sb);
	}

}
