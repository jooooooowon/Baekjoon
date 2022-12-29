package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quad_tree {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		quadtree(0,0,n);
		System.out.println(sb);
		
	}
	private static void quadtree(int col, int row, int size) {
		boolean tf = true;
		for(int i = col ; i < col + size; i++) {
			for(int j = row ; j < row +size; j++) {
				if(arr[i][j] != arr[col][row]) {
					tf = false;
					break ;
				}
			}
		}
		if(tf) {
			sb.append(arr[col][row]);
			return;
		}
		else {
			sb.append("(");
			int newsize = size/2;
			quadtree(col, row, newsize);
			quadtree(col, row + newsize, newsize);
			quadtree(col + newsize, row, newsize);
			quadtree(col + newsize, row + newsize, newsize);
			sb.append(")");
		}
	}

}
