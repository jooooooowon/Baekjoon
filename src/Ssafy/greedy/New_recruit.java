package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class New_recruit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 0 ; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			for(int i = 0 ; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				arr[doc] = interview;
			}
			int min = arr[1];
			int count = 1;
			for(int i = 2; i <= n ; i++) {
				if(arr[i] < min) {
					count++;
					min = arr[i];
				}
			}
			System.out.println(count);
		}
	}

}
