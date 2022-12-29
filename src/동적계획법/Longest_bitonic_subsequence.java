package µ¿Àû°èÈ¹¹ý;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Longest_bitonic_subsequence {
	static Integer[] temp;
	static Integer[] temp_1;
	static Integer[] temp_2;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		temp = new Integer[n];
		temp_1 = new Integer[n];
		temp_2 = new Integer[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < n ; i++) {
			temp_1[i] = 1;
			for(int j = 0 ; j < i; j++) {
				if(arr[i] > arr[j] && temp_1[i] == temp_1[j]) temp_1[i]++;
			}
		}
		for(int i = n - 1; i >= 0; i--) {
			temp_2[i] = 1;
			for(int j = n - 1 ; j > i; j--) {
				if(arr[i] > arr[j] && temp_2[i] == temp_2[j]) temp_2[i]++;
			}
		}
		for(int i = 0 ; i < n ; i++) {
			temp[i] = temp_1[i] + temp_2[i];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			if(max < temp[i]) max = temp[i];
		}
		
		
		System.out.println(max - 1);
	}

	
}

