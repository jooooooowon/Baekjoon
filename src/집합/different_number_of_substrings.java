package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class different_number_of_substrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashSet<String> hs = new HashSet<>();
		for(int i = 0 ; i < str.length(); i++) {
			for(int j = i + 1; j <= str.length(); j++) {
				hs.add(str.substring(i, j));
			}
		}
		System.out.println(hs.size());
	}

}
