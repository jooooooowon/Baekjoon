package silver.silver3;

import java.util.Scanner;

public class Snail {
	static int[][] arr;
	static int[] arr_y = {1,0,-1,0};
	static int[] arr_x= {0,1,0,-1};
	static int n;
	static int k;
	static int result_x;
	static int result_y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n+1][n+1];
		make(0, 1, 1, n*n);
		
	}
	private static void make(int idx, int y, int x, int num) {
		arr[y][x] = num;
		if(num == k) {
			result_x = x;
			result_y = y;
		}
		if(num == 1) {
			StringBuilder sb = new StringBuilder();
			for(int i = 1 ; i < n+1; i++) {
				for(int j = 1; j < n+1 ; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			sb.append(result_y +" " + result_x);
			System.out.println(sb);
			System.exit(0);
		}
		if(idx >= 4) idx = 0;
		
		int temp_y = y + arr_y[idx];
		int temp_x = x + arr_x[idx];
		
		if( temp_y > n || temp_y < 1 || temp_x > n || temp_x < 1 || arr[temp_y][temp_x] != 0 ) {
			make(idx+1,y,x,num);
		}
		else make(idx,temp_y,temp_x,num-1);
		
	}

}
