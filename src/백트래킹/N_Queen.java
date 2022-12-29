package 백트래킹;

import java.util.Scanner;

public class N_Queen {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[0] = i;
			N_Queen(n, arr, 1);
		}
		System.out.println(count);
	}

	private static void N_Queen(int n, int[] arr , int i) {
		if(i == n) {
			count++;
			return ;
		}
		
		for(int j = 0 ; j < n; j++) {
			boolean tf = true;
			arr[i] = j;
			for(int k = 0 ; k < i ; k++) {
				int temp = Math.abs(arr[i] - arr[k]);
				if(temp == 0) {
					tf = false;
					break ;
				}
				else if(temp == Math.abs(i - k)) {
					tf = false;
					break ;
				}
			}
			if(tf) {
				N_Queen(n, arr, i + 1);
			}
		}
		return ;
	}

}
