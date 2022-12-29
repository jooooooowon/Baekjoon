package 정수론및조합론;

import java.util.Arrays;
import java.util.Scanner;

public class examine2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int temp = arr[1] - arr[0];
		for(int i = 2 ; i < n ; i++) {
			int bigger = Math.max(temp, arr[i] - arr[i - 1]);
			int smaller = Math.min(temp, arr[i] - arr[i - 1]);
			int r; 
			while(true) {
				r = bigger % smaller;
				bigger = smaller;
				if(r == 0) break;
				smaller = r;
			}
			temp = smaller;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= temp; i++) {
			if(temp % i == 0) sb.append(i + " ");
		}
		System.out.println(sb);
	}

}
