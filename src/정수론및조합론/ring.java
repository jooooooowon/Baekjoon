package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ring {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < n ; i++) {
			int divisors = find_divisors(arr[0],arr[i]);
			sb.append(arr[0]/divisors + "/" + arr[i]/divisors + "\n");
		}
		System.out.println(sb);
	}

	private static int find_divisors(int i, int j) {
		int max = Math.max(i, j);
		int min = Math.min(i, j);
		int r;
		while(true) {
			r = max % min; 
			if(r == 0) break;
			max = min;
			min = r;
		}
		return min;
	}

}
