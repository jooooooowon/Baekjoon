package Àç±ÍÇÔ¼ö;

import java.util.Scanner;

public class hanoi_not_mine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.pow(n,2) - 1);
		hanoi(n, 1, 2, 3);
	}

	private static void hanoi(int n, int start, int mid, int end) {
		if(n == 1) {
			System.out.println(start + " " + end);
			return;
		}
		hanoi(n - 1, start, end, mid);
		System.out.println(start + " " + end);
		hanoi(n - 1, mid, start, end);
		return;
	}

}
