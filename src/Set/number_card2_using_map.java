package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class number_card2_using_map {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i = 0 ; i < n ; i++) {
			String num = st.nextToken();
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < m ; i++) {
			String fnd = st.nextToken();
			if(hm.containsKey(fnd)) sb.append(hm.get(fnd));
			else sb.append(0);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
