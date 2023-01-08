package DevideAndConquer;

import java.util.Scanner;

public class Multiplication {
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(multiplication(a,b));
	}

	private static long multiplication(int a, int b) {
		if(b > 0 ) {
			if(b % 2 == 1) {
				long temp = multiplication(a, b/2);
				return ((temp % c * temp % c) % c * (a % c)) % c;
			}
			else {
				long temp = multiplication(a, b/2);
				return (temp % c * temp % c) % c;
			}
		}
		else return 1;
	}

}
