package С§Че;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hearsay {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		for(int i = 0 ; i < n ; i++) {
			hs.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();
		int count = 0;
		for(int i = 0 ; i < m; i++) {
			String str = br.readLine();
			if(hs.contains(str)) {
				list.add(str);
				count++;
			}
		}
		
		list.sort(Comparator.naturalOrder());
		sb.append(count + "\n");
		count = 0;
		for(String str : list) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}

}
