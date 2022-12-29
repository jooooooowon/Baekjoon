package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class laying_a_bridge {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_count = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < test_count; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(laying_a_bridge(n, m) + "\n");
		}
		System.out.println(sb);
		
	}

	private static int laying_a_bridge(int n, int m) {
		if(n == 1) return m;
		if(n == m) return 1;
		return laying_a_bridge(n, m - 1) + laying_a_bridge(n - 1, m - 1);
	}
}
