package 정수론및조합론;

import java.util.Scanner;

public class number_of_combinations_of_zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int temp = n - m;
		
		int five = find_five(n) - find_five(m) - find_five(temp);
		int two = find_two(n) - find_two(m) - find_two(temp);
		System.out.println(Math.min(five, two));
		
	}

	private static int find_five(int n) {
		int i = 1;
		int result = 0;
		while(n >= Math.pow(5, i)) {
			result += n / Math.pow(5, i);
			i++;
		}
		return result;
	}

	private static int find_two(int n) {
		int i = 1;
		int result = 0;
		while(n >= Math.pow(2, i)) {
			result += n / Math.pow(2, i);
			i++;
		}
		return result;
	}

}
