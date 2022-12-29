package Ssafy.Dynamic;

import java.util.Scanner;

public class number_of_2chin {
	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1];
		
		dp[0] = 0;
		
		System.out.println(find(n));
	}
	private static long find(int n) {
		if(dp[n] != 0) return dp[n];
		else {
			long sum = 0;
			for(int i = 1 ; i < n-1 ; i++) {
				sum += find(i);
			}
			return dp[n] = sum+1;
		}
	}

}
