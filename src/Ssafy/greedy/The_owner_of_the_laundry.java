package Ssafy.greedy;

import java.util.Scanner;

public class The_owner_of_the_laundry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int change = sc.nextInt();    	 	// 0.25    0.1    0.05    0.01
			int quarter = 0;
			while(change / 25 != 0) {
				quarter++;
				change -= 25;
			}
			int dime = 0;
			while(change / 10 != 0) {
				dime++;
				change -= 10;
			}
			int nickel = 0;
			while(change / 5 != 0) {
				nickel++;
				change -= 5;
			}
			int penny = 0;
			while(change / 1 != 0) {
				penny++;
				change -= 1;
			}
			sb.append(quarter+" "+dime+" "+nickel+" "+penny+" \n");
		}
		System.out.println(sb);
	}

}
