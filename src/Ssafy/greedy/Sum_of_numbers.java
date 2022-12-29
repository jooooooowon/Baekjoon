package Ssafy.greedy;

import java.util.Scanner;

public class Sum_of_numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long count = 0;
			
		while(count * (count+1) <= 2*n) {
			count++;
		}
		System.out.println(count-1);
	}

}
