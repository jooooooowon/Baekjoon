package 브루트포스;

import java.util.Scanner;

public class blackjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(blackjack(arr, m));
	}

	private static int blackjack(int[] arr, int m) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				for(int k = j + 1; k < arr.length; k++) {
					if(result < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] +arr[k] <= m ) result = arr[i] + arr[j] + arr[k];
				}
			}
		}
		return result;
	}

}
