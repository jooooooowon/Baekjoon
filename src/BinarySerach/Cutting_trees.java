package BinarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cutting_trees {
	static long[] arr;
	static long m;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long start = 0;
		long end = arr[n - 1];
		while(start + 1 < end) {
			long mid = (start + end) / 2;
			if(check(mid)) start = mid;
			else end = mid - 1;
		}
		if(check(start + 1)) System.out.println(start + 1);
		else System.out.println(start);
	}
	private static boolean check(long mid) {
		long meter = 0;
		for(int i = 0 ; i < n ; i++) {
			if(arr[i] - mid > 0) meter += arr[i] - mid;
		}
		if(meter >= m) return true;
		else return false;
	}

}
