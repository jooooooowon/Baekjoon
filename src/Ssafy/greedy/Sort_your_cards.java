package Ssafy.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_your_cards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		for(int i = 0 ; i < t ; i++) {
			int n = sc.nextInt();
			pque.add(n);
		}
		int result = 0;
		if(t != 1){
			while(true) {
			int temp_1 = pque.poll();
			int temp_2 = pque.poll();
			int temp_sum = temp_1 + temp_2;
			result += temp_sum;
			
			if(pque.isEmpty()) break;
			else pque.add(temp_sum);
			}
		}
		System.out.println(result);
	}

}
