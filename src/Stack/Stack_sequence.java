package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack_sequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		stack.push(num);
		int[] arr = new int[n];
		for(int i = 0; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		int j = 0;
		boolean tf = false;
		StringBuilder sb = new StringBuilder();
		do {
			if(stack.contains(arr[j])) {
				if(stack.peek() == arr[j]) {
				sb.append("-\n");
				stack.pop();
				j++;
				}
				else {
					tf = true;
					break ;
				}
			}
			else {
				num++;
				stack.push(num);
				sb.append("+\n");
			}
			
			
		}while(j < n);
		if(tf) System.out.println("NO");
		else System.out.println(sb);
	}

}
