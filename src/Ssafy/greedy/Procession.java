package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Procession {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		boolean[][] a = new boolean[row][column];
		boolean[][] b = new boolean[row][column];
		
		for(int i = 0 ; i < row ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < column ; j++) {
				if(str.charAt(j) == '1') a[i][j] = true;
			}
		}
		for(int i = 0 ; i < row ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < column ; j++) {
				if(str.charAt(j) == '1') b[i][j] = true;
			}
		}
		int count = 0;
		for(int i = 0 ; i < row - 2 ; i++) {
			for(int j = 0 ; j < column - 2; j++) {
				if(a[i][j] != b[i][j]) {
					for(int temp_i = i; temp_i < i+3 ; temp_i++) {
						for(int temp_j = j ; temp_j < j+3 ; temp_j++) {
							a[temp_i][temp_j] = !a[temp_i][temp_j];
						}
					}
					count++;
				}
			}
		}
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				if(a[i][j] != b[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(count);
	}

}
