package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Difference_between_5_and_6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int[] a_min = new int[a.length()];
		int[] a_max = new int[a.length()];
		int[] b_min = new int[b.length()];
		int[] b_max = new int[b.length()];
		for(int i = 0 ; i < a.length(); i++) {
			int temp = Character.getNumericValue(a.charAt(i));
			if(temp == 5 || temp == 6) {
				a_min[i] = 5;
				a_max[i] = 6;
			}
			else {
				a_min[i] = temp;
				a_max[i] = temp;
			}
		}
		for(int i = 0 ; i < b.length(); i++) {
			int temp = Character.getNumericValue(b.charAt(i));
			if(temp == 5 || temp == 6) {
				b_min[i] = 5;
				b_max[i] = 6;
			}
			else {
				b_min[i] = temp;
				b_max[i] = temp;
			}
		}
		int result_min = 0;
		int result_max = 0;
		int temp = 1;
		for(int i = a.length()-1 ; i >= 0 ; i--) {
			result_min += temp * a_min[i];
			result_max += temp * a_max[i];
			temp *= 10;
		}
		temp = 1;
		for(int i = b.length()-1 ; i >= 0 ; i--) {
			result_min += temp * b_min[i];
			result_max += temp * b_max[i];
			temp *= 10;
		}
		System.out.println(result_min + " " + result_max);
	}

}
