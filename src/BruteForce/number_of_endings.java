package BruteForce;

import java.util.Scanner;

public class number_of_endings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(number_of_endings(num));
	}

	private static int number_of_endings(int num) {
		int n = 666;
		int count = 0;
		int i;
		for(i = n; ;i++) {
			int temp = i;
			while(temp > 665) {
				if(temp % 1000 == 666) {
					count++;
					break;
				}
				temp /= 10;
			}
			if(count == num) break;
		}
		return i;
	}
}
