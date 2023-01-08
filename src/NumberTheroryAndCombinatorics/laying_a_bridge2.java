package NumberTheroryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class laying_a_bridge2 {
	static int[][] arr = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_count = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < test_count; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(laying_a_bridge(m , n ) + "\n");
		}
		System.out.println(sb);
		
	}

	private static int laying_a_bridge(int n, int m) {
		if(arr[n][m] > 0) return arr[n][m];
		if(n == m || m == 0) return arr[n][m] = 1;
		return arr[n][m] = laying_a_bridge(n - 1, m - 1) + laying_a_bridge(n - 1, m);
	}
}
