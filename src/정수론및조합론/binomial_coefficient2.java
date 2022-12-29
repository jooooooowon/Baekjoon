package 정수론및조합론;

import java.util.Scanner;

public class binomial_coefficient2 {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n + 1][m + 1];
		System.out.println(binomial_coefficient2(n,m));
	}
	private static int binomial_coefficient2(int n, int m) {
		if(arr[n][m] > 0 ) return arr[n][m];
		else if(m == 0 || m == n) return arr[n][m] = 1;
		
		return arr[n][m] = ((binomial_coefficient2(n - 1, m - 1) + binomial_coefficient2(n - 1, m)) % 10007);
	}

}
