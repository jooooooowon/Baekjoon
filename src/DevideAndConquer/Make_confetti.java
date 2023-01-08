package DevideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Make_confetti {
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		make_confetti(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
	private static void make_confetti(int row, int col, int size) {
		boolean tf = true;
		for(int i = col; i < col + size; i++) {
			for(int j = row; j < row + size; j++) {
				if(arr[i][j] != arr[col][row]) {
					tf = false;
					break ;
				}
			}
		}
		if(tf) {
			if(arr[col][row] == 1) blue++;
			else if(arr[col][row] == 0) white++;
			return ;
		}
		else {
			int newsize = size / 2;
			make_confetti(row ,col ,newsize);
			make_confetti(row + newsize ,col ,newsize);
			make_confetti(row ,col + newsize,newsize);
			make_confetti(row + newsize,col + newsize,newsize);
		}
	}

}
