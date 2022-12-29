package Á¤·Ä;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int avg = arithmetic_mean(arr);
		int mid = arr[(int)(n/2)];
		int mode = Find_mode(arr);
		int range = arr[n - 1] - arr[0];
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(avg));
		bw.write("\n");
		bw.write(String.valueOf(mid));
		bw.write("\n");
		bw.write(String.valueOf(mode));
		bw.write("\n");
		bw.write(String.valueOf(range));
		bw.close();
	}

	private static int Find_mode(int[] arr) {
		int[] count = new int[8001];
		int i;
		for(i = 0 ; i < arr.length ; i++) {
			count[arr[i] + 4000]++;
		}
		int max = Integer.MIN_VALUE;
		for(i = 0 ; i < count.length; i++) {
			if(max < count[i]) max = count[i];
		}
		int cnt = 0;
		int temp = 0;
		for(i = 0 ; i < count.length; i++) {
			if(max == count[i]) {
				temp = i - 4000;
				cnt++;
			}
			if(cnt == 2) break;
		}
		
		return temp;
	}

	private static int arithmetic_mean(int[] arr) {
		double result = 0;
		for(int i = 0 ; i < arr.length; i++) {
			result += arr[i];
		}
		result /= arr.length;
		return (int)(Math.round(result));
	}
}
