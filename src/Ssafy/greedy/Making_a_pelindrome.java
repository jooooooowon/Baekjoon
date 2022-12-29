package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Making_a_pelindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length()];
		char[] result = new char[str.length()];
		for(int i = 0 ; i < str.length() ; i++) {
			arr[i] = str.charAt(i);
		}
		Arrays.sort(arr);
		for(int i = 0 ,j = 0; i < str.length() ; i++) {
			result[j] = arr[i];
			if(++i < str.length()) result[str.length() - 1 - j] = arr[i];
			j++;
		}
		for(int i = 0 ; i < str.length()/2 ; i++) {
			if(result[i] != result[str.length()-1-i]) {
				System.out.println("I'm Sorry Hansoo");
				System.exit(0);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length() ; i++) {
			sb.append(result[i]);
		}
		System.out.println(sb);
	}

}
