package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix_multiplication {
	static int[][] A;
	static int[][] B;
	static int[][] C;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		B = new int[m][k];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < k ; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		C = new int[n][k];
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < k ; j++) {
				row_sum(i,j);
				sb.append(C[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static void row_sum(int i, int j) {
		for(int idx = 0 ; idx < m ; idx++) {
			C[i][j] += A[i][idx] * B[idx][j];
		}
	}
}
