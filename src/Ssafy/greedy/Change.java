package Ssafy.greedy;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = 1000 - n;
		int count = 0;
		while(n>=500) {
			count++;
			n -= 500;
		}
		while(n>=100) {
			count++;
			n -= 100;
		}
		while(n>=50) {
			count++;
			n -= 50;
		}
		while(n>=10) {
			count++;
			n -= 10;
		}
		while(n>=5) {
			count++;
			n -= 5;
		}
		while(n>=1) {
			count++;
			n -= 1;
		}
		System.out.println(count);
		
	}

}
