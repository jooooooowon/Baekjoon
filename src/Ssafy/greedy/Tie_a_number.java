package Ssafy.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tie_a_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> rque = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			int temp = sc.nextInt();
			if(temp > 0) rque.offer(temp);
			else pque.offer(temp);
		}
		
		int result = 0;
		while(!rque.isEmpty()) {
			int temp_1 = rque.poll();
			if(!rque.isEmpty()) {
				int temp_2 = rque.poll();
				result += Math.max(temp_1 + temp_2 ,temp_1 * temp_2);
			}
			else result += temp_1;
		}
		while(!pque.isEmpty()) {
			int temp_1 = pque.poll();
			if(!pque.isEmpty()) {
				int temp_2 = pque.poll();
				result += Math.max(temp_1 + temp_2 ,temp_1 * temp_2);
			}
			else result += temp_1;
		}
		
		System.out.println(result);

	}
}
