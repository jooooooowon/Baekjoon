package 분할정복;

import java.util.Scanner;

public class Binomial_coefficient_3_using_dynamic_program {
	static int mod = 1000000007;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		arr = new int[n + 1][k + 1];
		System.out.println(binomial_coefficient(n,k));
	}
	private static int binomial_coefficient(int i, int j) {
		if(j == 0 || i == j) {
			return 1;
		}
		return arr[i][j] = ((binomial_coefficient(i - 1, j) % mod) + (binomial_coefficient(i - 1, j - 1) % mod)) % mod;
	}

}
