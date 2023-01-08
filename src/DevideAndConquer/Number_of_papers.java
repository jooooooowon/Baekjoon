package DevideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_of_papers {
	static int[][] arr;
	static int minus = 0;
	static int zero = 0;
	static int one = 0;
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
		papers(0,0,n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	private static void papers(int col, int row, int size) {
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
			if(arr[col][row] == -1) minus++;
			else if(arr[col][row] == 0) zero++;
			else if(arr[col][row] == 1) one++;
			return ;
		}
		else {
			int newsize = size/3;
			papers(col, row, newsize);
			papers(col, row + newsize, newsize);
			papers(col, row + newsize + newsize, newsize);
			papers(col + newsize, row, newsize);
			papers(col + newsize + newsize, row, newsize);
			papers(col + newsize, row + newsize, newsize);
			papers(col + newsize + newsize, row + newsize, newsize);
			papers(col + newsize, row + newsize + newsize, newsize);
			papers(col + newsize + newsize, row + newsize + newsize, newsize);
		}
	}

}
