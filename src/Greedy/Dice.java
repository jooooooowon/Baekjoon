package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dice {
	static int[] arr = new int[6];
	static boolean[] tf = new boolean[6];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min_1 = 50;
		int sum = 0;
		int max = 0;
		for(int i = 0 ; i < 6 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min_1 = Math.min(arr[i], min_1);
			max = Math.max(arr[i], max);
			sum += arr[i];
		}
		if(n == 1) {
			sum -= max;
			System.out.println(sum);
			System.exit(0);
		}
		int min_3 = Math.min(150,combination(3,0,150));
		int min_2 = Math.min(100,combination(2,0,100));
		long result = 0;
		result += 4 * min_3;
		result += min_2 * ((n-1)*4 + (n-2)*4);
		result += min_1 * (Math.pow(n-2, 2)*5 +(n-2)*4);
		System.out.println(result);
		
		
	}
	private static int combination(int r, int start,int temp_min) {
		if(r == 0) {
			int temp_sum = 0;
			for(int i = 0 ; i < 6 ; i++) {
				if(tf[i] && tf[5-i]) {
					return temp_min;
				}
				if(tf[i]) temp_sum += arr[i];
			}
			return temp_min = Math.min(temp_min, temp_sum);
		}
		else {
			for(int i = start ; i < 6 ; i++) {
				tf[i] = true;
				temp_min = Math.min(temp_min,combination(r-1,i+1,temp_min));
				tf[i] = false;
			}
			return temp_min;
		}
	}

}
