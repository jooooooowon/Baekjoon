package NumberTheroryAndCombinatorics;

import java.util.Scanner;

public class number_of_factorial_zeros2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int result = 1;
		for(int i = 2 ; i <= n; i++) {
			result *= i;
			while(result >= 10) {
				if(result % 10 == 0) {
					count++;
					result /= 10;
				}
				else result %= 10;
			}
		}
		System.out.println(count);
	}
}
