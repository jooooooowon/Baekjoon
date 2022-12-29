package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Double_armed_scale {
	static int[] arr;
	static boolean[][] dp = new boolean[31][40001];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		fnd(0,0);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			int weight = Integer.parseInt(st.nextToken());
			if(dp[n][weight]) sb.append("Y ");
			else sb.append("N ");
		}
		System.out.println(sb);
	}
	private static void fnd(int cnt, int weight) {
		if(dp[cnt][weight]) return;
		dp[cnt][weight] = true;
		if(cnt == n) return;
		fnd(cnt + 1, weight + arr[cnt + 1]);					// 다음 값을 넣을 때
		fnd(cnt + 1, weight);									// 이 값을 유지 할 때 ->  이 값이 있어야 첫 번째 + 세 번째, |첫 번째 - 세 번째|등의 계산이 가능하고 첫 번째 수의 유지도 가능하다.
		fnd(cnt + 1, Math.abs(weight - arr[cnt + 1]));			// 다음 값과의 차이
	}

}
