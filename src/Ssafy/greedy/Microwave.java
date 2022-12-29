package Ssafy.greedy;

import java.util.Scanner;

public class Microwave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int five_min = 0;
		int one_min = 0;
		int ten_sec = 0;
		while(n >= 5*60) {
			five_min++;
			n -= 5*60;
		}
		while(n >= 1*60) {
				one_min++;
		n -= 1*60;
		}
		while(n >= 10) {
			ten_sec++;
			n -= 10;
		}
		if(n != 0) System.out.println(-1);
		else System.out.println(five_min+" "+one_min+" "+ten_sec);
	}

}
