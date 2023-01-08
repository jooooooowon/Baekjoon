package BruteForce;

import java.util.Scanner;

public class number_of_endings_666 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(number_of_endings_666(num));
	}

	private static int number_of_endings_666(int num) {
		int n = 666;
		int count = 0;
		int i;
		for(i = n; ;i++) {
			int temp = i;
			do {
				int len = (int)(Math.log10(temp));
				if(temp/((int)(Math.pow(10, len))) == 6) {
					temp = temp - (temp/(int)(Math.pow(10, len)))*(int)(Math.pow(10, len));
					len--;
					if(temp/((int)(Math.pow(10, len))) == 6) {
						temp = temp - (temp/(int)(Math.pow(10, len)))*(int)(Math.pow(10, len));
						len--;
						if(temp/((int)(Math.pow(10, len))) == 6) {
							count++;
							break;
						}
					 }
				}
				temp = temp - (temp/(int)(Math.pow(10, len)))*(int)(Math.pow(10, len));
			} while((int)(Math.log10(temp)) + 1 >= 3);
			if(count == num) break;
		}
		return i;
	}

}
