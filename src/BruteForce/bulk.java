package BruteForce;

import java.util.Scanner;

public class bulk {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int[] rnk = new int[n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		bulk(arr,rnk,n);
		for(int i = 0; i < n ; i++) {
			System.out.print(rnk[i] + " ");
		}
	}

	private static void bulk(int[][] arr, int[] rnk, int n) {
		int count;
		for(int i = 0 ; i < n ; i++) {
			count = 0;
			for(int j = 0 ; j < n; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
			rnk[i] = count + 1;
		}
	}

}
