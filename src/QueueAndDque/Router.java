package QueueAndDque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Router {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> dque = new ArrayDeque<Integer>();
		while(true) {
			int temp = sc.nextInt();
			if(temp == -1) break;
			else if(temp == 0) dque.pollFirst();
			else if(dque.size() < n) dque.offerLast(temp);
			
		}
		if(dque.isEmpty()) System.out.println("empty");
		else{
			StringBuilder sb = new StringBuilder();
			while(!dque.isEmpty()) {
				sb.append(dque.pollFirst()).append(" ");
			}
			System.out.println(sb);
		}
	}

}
