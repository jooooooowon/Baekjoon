package DevideAndConquer;

import java.util.Scanner;

public class Binomial_coefficient_3 {
	static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long mod_n = 1;
		long mod_k = 1;
		long mod_n_k = 1;
		for(int i = 1 ; i <= n; i++) {
			mod_n *= (i % mod);
			mod_n %= mod;
		}
		for(int i = 1 ; i <= k; i++) {
			mod_k *= (i % mod);
			mod_k %= mod;
		}
		for(int i = 1 ; i <= n - k; i++) {
			mod_n_k *= (i % mod) % mod;
			mod_n_k %= mod;
		}
		long result = mod_k * mod_n_k % mod;
		
		System.out.println(mod_n * multiplication(result, mod - 2) % mod);
	}
	private static long multiplication(long result, int i) {
		if(i > 0) {
			if(i % 2 == 0) {
				long temp = multiplication(result, i / 2) ;
				return temp % mod * temp % mod % mod;
			}
			else {
				long temp = multiplication(result, i / 2) ;
				return temp % mod * temp % mod* result % mod % mod;
			}
		}
		return 1;
	}
}
