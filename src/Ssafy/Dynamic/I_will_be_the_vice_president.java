package Ssafy.Dynamic;

import java.util.Scanner;

public class I_will_be_the_vice_president {
	static int k;
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++) {
			k = sc.nextInt();
			n = sc.nextInt();
			arr = new int[k+1][n+1];
			for(int j = 1 ; j <= n ; j++) {
				arr[0][j] = j;
			}
			System.out.println(find(1));
			System.out.println(arr[k][n]);
			
		}
	}

	private static int find(int floor) {
		if(floor > k) return arr[floor-1][n];
		else {
			for(int i = 1; i <= n ; i++) {
				arr[floor][i] += arr[floor-1][i] + arr[floor][i-1];
			}
			return find(floor+1);
		}
		
	}


}
