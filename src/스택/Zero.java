package Ω∫≈√;

import java.util.Scanner;
import java.util.Stack;

public class Zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n ; i++) {
			int num = sc.nextInt();
			if(num == 0 && !stack.isEmpty()) {
				stack.pop();
			}
			else stack.push(num);
		}
		while(stack.size() > 0) {
			sum += stack.peek();
			stack.pop();
		}
		System.out.println(sum);
	}

}
