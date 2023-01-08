package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class word_sort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for(int i = 0 ; i < n ; i++) {
			str[i] = br.readLine();
		}
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(str));
		str = hashSet.toArray(new String[0]);
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				else return s1.length() - s2.length();
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length ; i++) {
			sb.append(str[i]).append("\n");
		}
		System.out.println(sb);
		
	}

}
