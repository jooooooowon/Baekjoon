package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for(int i = 1 ; i < n + 1 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] temp = new int[n + 1];
		for(int i = 1 ; i < n + 1 ; i++) {
			temp[i] = temp[i-1] + arr[i];
		}
		int sum = 0;
		for(int i = 1 ; i < n + 1 ; i++) {
			sum += temp[i];
		}
		System.out.println(sum);
	}

}
