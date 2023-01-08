package Recursion;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(facto(num,1));
	}

	private static int facto(int num,int result) {
		if(num == 0) return result;
		result *= num;
		return facto(num - 1, result);
	}

}
