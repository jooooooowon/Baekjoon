package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin_0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int result = 0;
		int count = 0 ;
		int i = n - 1;
		while(i >= 0) {
			result += arr[i];
			if(result > k) {
				result -= arr[i];
				i--;
			}
			else if(result == k) {
				count++;
				break;
			}
			else {
				count++;
			}
		}
		System.out.println(count);
	}

}
