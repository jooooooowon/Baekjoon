package NumberTheroryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Fashion_king_Shin_hye_bin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0 ; i < n ; i++) {
			int count = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for(int j = 0; j < count; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); 
				String temp = st.nextToken(); 
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
			System.out.println(Fashion_king_Shin_hye_bin(map));
		}
	}

	private static int Fashion_king_Shin_hye_bin(HashMap<String, Integer> map) {
		int[] temp = new int[map.size()];
		int index = 0;
		int result = 1;
		for(String str : map.keySet()) {
			temp[index] = map.get(str);
			index++;
		}
		for(int i = 0 ; i < temp.length; i++) {
			result *= temp[i] + 1;
		}
		return result - 1;
	}

}
