package Á¤·Ä;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Aligning_coordinates {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		aligning_coordinates(arr,n);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		System.out.println(sb);
	}
	private static void aligning_coordinates(int[][] arr, int n) {
		int j = 0;
		while(j < n - 1) {
			for(int i = 0 ; i < n - 1; i++) {
				if(arr[i][0] > arr[i + 1][0]) {
					swap(arr, i);
				}
				else if(arr[i][0] == arr[i + 1][0] && arr[i][1] > arr[i + 1][1]) {
					swap(arr, i);
				}
			}
			j++;
		}
	}
	private static void swap(int[][] arr, int i) {
		int[] temp;
		temp = arr[i + 1];
		arr[i + 1] = arr[i];
		arr[i] = temp;
	}
}
