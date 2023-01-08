package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Longest_increasing_sequence {
	static Integer[][] temp; 
	static int[] arr; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		temp = new Integer[n][2];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n ; i++) {
			temp[i][0] = 1;
			temp[i][1] = arr[i];
			for(int j = i; j < n - 1 ; j++) {
				if(arr[j + 1] > temp[i][1]) {
					temp[i][0]++;
					temp[i][1] = arr[j + 1];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			if(max < temp[i][0]) max = temp[i][0];
		}
		
		System.out.println(max);
		
	}

}
