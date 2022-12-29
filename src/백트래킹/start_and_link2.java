package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class start_and_link2 {
	static int min = 100;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		HashSet<Integer> hs = new HashSet<>();
		HashSet<Integer> temp = new HashSet<>();
		start_and_link_combinations(n, hs, temp, arr);
		System.out.println(min);
	
	}

	private static void start_and_link_combinations(int n, HashSet<Integer> hs, HashSet<Integer> temp, int[][] arr) {
		if(hs.size() == n/2) {
			for(int i = 0; i < n ; i++) {
				if(!hs.contains(i)) {
					temp.add(i);
				}
			}
			int num1 = 0;
			for(int i : hs) {
				for(int j : hs) {
					if(i != j) {
					num1 += arr[i][j];
					}
				}
			}
			for(int i : temp) {
				for(int j : temp) {
					if(i != j) {
						num1 -= arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(num1));
			return ;
		}
		for(int j = 0; j < n; j++) {
			if(!hs.contains(j)) {
				hs.add(j);
				start_and_link_combinations(n, hs, temp, arr);
				hs.remove(j);
				temp.clear();
			}
			
		}
			
		return ;
	}
}
