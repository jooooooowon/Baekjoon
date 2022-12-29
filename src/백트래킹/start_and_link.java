package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class start_and_link {
	static int min = 100;
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		HashSet<Integer> hs = new HashSet<>();
		start_and_link_combinations(hs, 0);
		System.out.println(min);
	
	}

	private static void start_and_link_combinations(HashSet<Integer> hs, int i) {
		if(hs.size() == n/2) {
			
			int num1 = 0;
			for(int k = 0 ; k < n ; k++) {
				for(int j = k + 1 ; j < n ; j++) {
					if(hs.contains(k) && hs.contains(j)) {
						num1 += arr[k][j];
						num1 += arr[j][k];
					}
					else if(!hs.contains(k) && !hs.contains(j)) {
						num1 -= arr[k][j];
						num1 -= arr[j][k];
					}
				}
			}
			
			min = Math.min(min, Math.abs(num1));
			if (min == 0) {
				System.out.println(0);
				System.exit(0);
			}
			return ;
		}
		for(int j = i; j < n; j++) {
			if(!hs.contains(j)) {
				hs.add(j);
				start_and_link_combinations(hs, i + 1);
				hs.remove(j);
			}
		}
		return ;
	}
}
