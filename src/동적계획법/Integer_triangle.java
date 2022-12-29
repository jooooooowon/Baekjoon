package µ¿Àû°èÈ¹¹ý;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Integer_triangle {
	static Integer[][] temp;
	static int size;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[size][size];
		temp = new Integer[size][size];
		for(int i = 0 ; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < size; i++) {
			temp[size - 1][i] = arr[size - 1][i];
		}
		System.out.println(Integer_Triangle(0, 0));
		
	}

	private static int Integer_Triangle(int i, int j) {
		
		if(temp[i][j] == null) {
			temp[i][j] = Math.max(Integer_Triangle(i + 1, j), Integer_Triangle(i + 1, j + 1)) + arr[i][j];
		}
		else if (i == size - 1) return temp[i][j];
		return temp[i][j];
	}
	
}
