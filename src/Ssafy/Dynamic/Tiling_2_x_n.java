package Ssafy.Dynamic;

import java.util.Scanner;

public class Tiling_2_x_n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		System.out.println(find(arr, n));
	}

	private static int find(int[] arr, int n) {
		if(arr[n] == 0) return arr[n] = (2*find(arr,n-2) + find(arr,n-1)) % 10007;
		else return arr[n];
	}

}
