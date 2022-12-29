package ДЉРћЧе;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Human_computer_interaction {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		long n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char ch = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = 0;
			for(int j = start; j <= end; j++) {
				if(str.charAt(j) == ch) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
