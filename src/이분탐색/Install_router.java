package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Install_router {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[n - 1];
		while(start < end) {
			int mid = (start + end) / 2;
			int check = chk(mid);
			if(check < c) {
				end = mid;
			}
			else if(check >= c){
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}
	private static int chk(int mid) {
		int location = arr[0];
		int count = 1;
		for(int i = 1 ; i < n ; i++) {
			if(location + mid <= arr[i]) {
				count++;
				location = arr[i];
			}
		}
		return count;
	}

}
