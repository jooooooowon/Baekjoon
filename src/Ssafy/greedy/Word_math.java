package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Word_math {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> hsmap = new HashMap<>();
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			int seats = 1;
			for(int j = str.length()-1 ; j >= 0; j--) {
				hsmap.put(str.charAt(j),hsmap.getOrDefault(str.charAt(j), 0)+seats);
				seats *= 10;
			}
		}
		List<Integer> list = new ArrayList<>(hsmap.values());
		Collections.sort(list, Collections.reverseOrder());
		int temp = 9;
		int result = 0;
		for(int i : list) {
			result += i*temp;
			temp--;
		}
		System.out.println(result);
	}

}
