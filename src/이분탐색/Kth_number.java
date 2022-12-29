package ÀÌºÐÅ½»ö;

import java.util.Scanner;

public class Kth_number {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		long start = 1;
		long end = (long)Math.pow(n, 2);
		while(start < end) {
			long mid = (start + end)/2;
			long chk  = kth_num(mid);
			if(chk >= k) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}

	private static long kth_num(long mid) {
		long count = 0;
		for(int i = 1; i <= n; i++) {
			count += Math.min(mid / i, n);
		}
		
		return count;
	}

}
