package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Start_and_link2 {
	static int[][] arr;
	static int n;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] tf = new boolean[n+1];
		find(tf,1,0);
		System.out.println(result);
	}

	private static void find(boolean[] tf, int num, int count) {
		if(count == n/2){
			int temp = 0;
			for(int i = 1; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(tf[i] && tf [j]) temp += arr[i][j];
					else if(!tf[i] && !tf[j]) temp -= arr[i][j];
				}
			}
			result = Math.min(result, Math.abs(temp));
			if(result == 0) {
				System.out.println(0);
				System.exit(0);
			}
			return ;
		}
		for(int i = num ; i <= n ; i++) {
			if(tf[i]) continue ;
			tf[i] = true;
			find(tf, i, count + 1);
			tf[i] = false;
		}
		return ;
	}

}
