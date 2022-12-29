package Ssafy.Dynamic;

import java.util.Scanner;

public class Sugar_delivery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[5001];
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		System.out.println(find(dp,n));
	}

	private static int find(int[] dp, int idx) {
		if(dp[idx] == 0) {
			int temp = find(dp,idx - 5);
			if(temp == -1) temp = find(dp, idx - 3);
			if(temp == -1) return temp;
			return dp[idx] = temp + 1;
		}
		
		return dp[idx];
	}

}
