package BackTracking;

import java.util.Scanner;

public class N_and_M_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		for(int i = 1; i <= n ; i++) {
			arr[0] = i;
			N_and_M(n, m, arr, 1);
		}
	}

	private static void N_and_M(int n, int m, int[] arr, int i) {
		if(i == m) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			return;
		}
		for(int j = arr[i - 1] + 1; j <= n; j++) {
				arr[i] = j;
				N_and_M(n, m, arr, i + 1);
		}
		
		return ;
	}

}
