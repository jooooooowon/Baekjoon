package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guitar_strings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int min_package = Integer.MAX_VALUE;
		int min_indiv = Integer.MAX_VALUE;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			min_package = Math.min(Integer.parseInt(st.nextToken()), min_package);
			min_indiv = Math.min(Integer.parseInt(st.nextToken()), min_indiv);
		}
		int result = 0;
		while(n >= 6) {
			result += Math.min(min_package, min_indiv * 6);
			n -= 6;
		}
		if(n < 6 && n > 0) result += Math.min(min_indiv * n, min_package);
		System.out.println(result);
	}

}
