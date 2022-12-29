package µ¿Àû°èÈ¹¹ý2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Double_armed_scale2 {
	static ArrayList<Integer> arr;
	static int n;
	static String[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp = 0;
		for(int i = 1 ; i <= n ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
			temp += arr.get(i-1);
		}
		dp = new String[temp+1];
		dp[0] = "Y";
		for(int i = 1; i <= temp ; i++) {
			dp[i] = "Empty";
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			int weight = Integer.parseInt(st.nextToken());
			String result = doubled_armed_scale(0,weight);
			sb.append(result).append(" ");
		}
	}
	private static String doubled_armed_scale(int idx, int weight) {
		
		if(weight > dp.length - 1) return "N"; 
		else if (weight == idx) return dp[weight] = "Y";
		else if(dp[weight].equals("Y")) return dp[weight];
		else {
			for(int i : arr) {
				int temp_plus = idx + i;
				int temp_minus = idx - i;
				if(weight > idx) {
					if(temp_plus == weight) return dp[weight] = "Y";
					else doubled_armed_scale(temp_plus, weight);
				}
				if(weight < idx) {
					if(temp_minus == weight) return dp[weight] = "Y";
					else doubled_armed_scale(temp_minus, weight);
				}
			}
			return dp[weight] = "N";
		}
	}

}
