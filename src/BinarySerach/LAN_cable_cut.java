package BinarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LAN_cable_cut {
	static int k;
	static long n;
	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Long.parseLong(st.nextToken());
		arr = new long[k];
		for(int i = 0 ; i < k ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long end = arr[k - 1];
		long start = 0;
		while(start + 1 < end) {
			long mid = (end + start) / 2;
			if(check(mid)) start = mid;
			else end = mid - 1;
		}
		if(check(start + 1)) System.out.println(start + 1);
		else System.out.println(start);
	}

	private static boolean check(long mid) {
		long count = 0;
		for(int i = 0 ; i < k ; i++) {
			count += arr[i] / mid;
		}
		if(count >= n) return true;
		return false;
	}

}
