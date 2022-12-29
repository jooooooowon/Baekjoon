package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int temp = 0;
		for(int i = 0 ; i < x; i++) {
			temp += arr[i];
		}
		
		int temp_1 = temp;
		max = Math.max(max, temp_1);
		for(int i = 0 ; i < n-x; i++) {
			temp_1 -= arr[i];
			temp_1 += arr[i+x];
			max = Math.max(temp_1, max);
		}
		if(max == 0) {
			System.out.println("SAD");
			System.exit(0);
		}
		if(n == x) {
			System.out.println(temp);
			System.out.println(1);
			
			System.exit(0);
		}
		int count = 0;
		int temp_2 = temp;
		for(int i = 0 ; i < n-x; i++) {
			if(temp_2 == max) count++;
			temp_2 -= arr[i];
			temp_2 += arr[i+x];
		}
		if(temp_2 == max) count++;
		System.out.printf(max + "\n" + count);
	}

}
