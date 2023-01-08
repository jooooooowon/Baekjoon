package DynamicPlanning2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin_1 {
	static int[] arr;
	static int[] dp = new int[1000001];
	static int n;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		coin(1,0);
		System.out.println(dp[k]);
		
	}
	private static void coin(int idx,int result) {
		if(result > k) return ;
		for(int i = idx; i <= n ; i++) {
			result += arr[i];
			dp[result]++;
			coin(i,result);
			result -= arr[i];
		}
		
	}
	

}
