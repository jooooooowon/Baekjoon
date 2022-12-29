package 분할정복;

import java.util.Scanner;

public class Fibonacci_num_6 {
	static int mod = 1000000007;
	static long[][] arr = new long[2][2];
	static long[][] for_awhile = new long[2][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[1][0] = 1;
		arr[1][1] = 0;
		long[][] result = fibonacci(n - 1);
		System.out.println(result[0][0] % mod);
	}
	private static long[][] fibonacci(long n) {
		if(n == 1 || n == 0) return arr;
		else {
			if(n % 2 == 0) {
				for_awhile = fibonacci(n/2);
				return make_temp();
			}
			else {
				for_awhile = fibonacci(n/2);
				for_awhile = make_temp();
				return multiple_arr();
			}
		}
	}
	private static long[][] multiple_arr() {
		long[][] temp = new long[2][2];
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0; j < 2 ; j++) {
				squared_arr(temp, i , j);
			}
		}
		return temp;
	}
	private static void squared_arr(long[][] temp, int i, int j) {
		for(int idx = 0 ; idx < 2 ; idx++) {
			temp[i][j] += (for_awhile[i][idx] % mod * arr[idx][j] % mod) % mod;
			temp[i][j] %= mod;
		}
	}
	private static long[][] make_temp() {
		long[][] temp = new long[2][2];
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0; j < 2 ; j++) {
				squared_temp(temp, i , j);
			}
		}
		return temp;
	}
	private static void squared_temp(long[][] temp, int i , int j) {
		for(int idx = 0 ; idx < 2 ; idx++) {
			temp[i][j] += (for_awhile[i][idx] % mod * for_awhile[idx][j] % mod) % mod;
			temp[i][j] %= mod;
		}
	}

}
