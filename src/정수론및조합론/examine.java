package 정수론및조합론;

import java.util.Scanner;

public class examine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] =sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for(int num = 2; num <= 100; num++) {
			int i;
			for(i = 0; i < n - 1 ; i++) {
				if(arr[i] % num != arr[i + 1] % num) break;
			}
			if(i == n - 1) sb.append(num + " ");
		}
		System.out.println(sb);
	}

}
