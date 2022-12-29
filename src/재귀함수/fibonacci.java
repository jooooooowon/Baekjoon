package Àç±ÍÇÔ¼ö;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num + 1];
		if(num == 0) System.out.println(0);
		else System.out.println(fibo(num,arr,0));
	}

	private static int fibo(int num,int[] arr,int i) {
		arr[0] = 0;
		arr[1] = 1;
		if(i >= 2) arr[i] = arr[i - 2] + arr[i - 1];
		if(num == i) return arr[num];
		return fibo(num,arr,i + 1);
	}

}
