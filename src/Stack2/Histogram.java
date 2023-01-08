package Stack2;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+2];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		Stack<Integer> height = new Stack<>();
		height.add(0);
		for(int i = 1 ; i <= n+1 ; i++) {
			while(!height.isEmpty() && arr[i] < arr[height.peek()]) {
				int temp = height.pop();
				ans = Math.max(ans, (i - height.peek() - 1) * arr[temp]);
			}
			height.add(i);
		}
		System.out.println(ans);
	}

}
