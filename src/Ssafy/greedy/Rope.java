package Ssafy.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rope {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr,Collections.reverseOrder());
		int result = 0;
		for(int i = 0 ; i < n ; i++) {
			result = Math.max(arr[i] * (i+1),result);
		}
		System.out.println(result);
	}
	
}
