package Ssafy.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Thirty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		Integer[] arr = new Integer[len];
		for(int i = 0; i < len ; i++) {
			arr[i] = Character.getNumericValue(str.charAt(i));
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int temp = 0;
		boolean tf = false;
		for(int i = 0 ; i < len ; i++) {
			temp += arr[i];
			if(arr[i] == 0) tf = true;
		}
		if(temp % 3 != 0 || !tf) System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < len; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}
	}

}
