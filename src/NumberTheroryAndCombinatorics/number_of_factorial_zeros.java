package NumberTheroryAndCombinatorics;

import java.util.Scanner;

public class number_of_factorial_zeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		count = n/5 + n/25 + n/125;
		System.out.println(count);
	}
}
  