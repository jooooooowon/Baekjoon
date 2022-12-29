package Àç±ÍÇÔ¼ö;

import java.util.Scanner;

public class stars {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		letstar(n, 0, 0, false, arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void letstar(int n, int x, int y, boolean chk, char[][] arr) {
		if(chk == true) {
			for(int i = x; i < x + n; i++) {
				for(int j = y ; j < y + n; j++) arr[i][j] = ' ';
			}
			return ;
		}
		if(n == 1) {
			arr[x][y] = '*';
			return ;
		}
		
		int size = n / 3;
		int count = 0;
		for(int i = x; i < x + n ; i += size) {
			for(int j = y; j < y + n; j += size) {
				count++;
				if(count == 5) letstar(size, i, j, true, arr);
				else letstar(size, i, j, false, arr);
			}
		}
	}
}
