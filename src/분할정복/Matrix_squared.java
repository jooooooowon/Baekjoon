package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix_squared {
	static int n;
	static long[][] arr;
	static long[][] for_awhile;
	
	static int mod = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		arr = new long[n][n];
		for_awhile = new long[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		
		long[][] result = matrix(B);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static long[][] matrix(long b) {
		if(b == 1) return arr;
		else {
			if(b % 2 == 0) {
				for_awhile = matrix(b/2);
				return Calculate_temp();
			}
			else {
				for_awhile = matrix(b/2);
				for_awhile = Calculate_temp();
				return Calculate_arr();
			}
		}
		
	}
	private static long[][] Calculate_temp() {
		long[][] temp = new long[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				Squared_temp(i,j,temp);
			}
		}
		return temp;
	}
	private static void Squared_temp(int i, int j, long[][] temp) {
		for(int idx = 0 ; idx < n ; idx++) {
			temp[i][j] += ((for_awhile[i][idx] % mod) * (for_awhile[idx][j] % mod)) % mod;
			temp[i][j] %= mod;
		}		
	}
	private static long[][] Calculate_arr() {
		long[][] temp= new long[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				Squared_arr(i,j,temp);
			}
		}
		return temp;
	}
	private static void Squared_arr(int i, int j, long[][] temp) {
		for(int idx = 0 ; idx < n ; idx++) {
			temp[i][j] += ((for_awhile[i][idx] % mod) * (arr[idx][j] % mod)) % mod;
			temp[i][j] %= mod;
		}
	}

}
