package Ssafy.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Schedule{
	int value;
	int time;
	Schedule(int value, int time) {
		this.value = value;
		this.time = time;
	}
}	
public class Retirement {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Schedule[] arr = new Schedule[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int value= Integer.parseInt(st.nextToken());
			arr[i] = new Schedule(value, time);
		}	
		int[] dp = new int[n+1];
		for(int i = 0 ; i < n ; i++) {
			if(i + arr[i].time <= n) {
				dp[i + arr[i].time] = Math.max(dp[i + arr[i].time], dp[i] + arr[i].value);
			}
			dp[i+1] = Math.max(dp[i], dp[i+1]);
			}
		System.out.println(dp[n]);
	}

}
