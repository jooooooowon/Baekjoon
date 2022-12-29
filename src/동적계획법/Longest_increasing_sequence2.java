package µ¿Àû°èÈ¹¹ý;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Longest_increasing_sequence2 {
	static int[] temp; 
	static int[] arr; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		temp = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < n ; i++) {
			temp[i] = 1;
			for(int j = 0 ; j < n ; j++) {
				if(arr[i] > arr[j] && temp[i] == temp[j]) {
					temp[i]++;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			if(max < temp[i]) max = temp[i];
		}
		
		System.out.println(max);
		
	}


}
