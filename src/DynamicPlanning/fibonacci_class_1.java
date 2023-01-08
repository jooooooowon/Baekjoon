package DynamicPlanning;

import java.util.Scanner;

public class fibonacci_class_1 {
	static int fibonacci_count = 0;
	static int fib_count = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		fib(n);
		fibonacci(n);
		System.out.print(fib_count + " " + fibonacci_count);
	}
	private static int fib(int n) {
		if(n == 1 || n == 2) {
			fib_count++;
			return 1;
		}
		return fib(n - 2) + fib(n - 1);
	}
	private static void fibonacci(int n) {
		arr[0] = 0; arr[1] = 1; arr[2] = 1;
		for(int i = 3; i < n + 1; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			fibonacci_count++;
		}
	}

}
