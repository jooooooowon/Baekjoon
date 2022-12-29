package 정수론및조합론;

import java.util.Scanner;

public class binomial_coefficient1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int molecule; 
		int denominator;
		if(m == 0) System.out.println(1);
		else {
			molecule = factorial(n,n - m + 1);
			denominator = factorial(m,1);
			System.out.println(molecule/denominator);
		}
		
	}

	private static int factorial(int n, int m) {
		if(n == m) return m;
		return factorial(n - 1, m) * n;
	}

}
