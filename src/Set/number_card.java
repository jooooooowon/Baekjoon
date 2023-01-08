package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class number_card {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> nset = new HashSet<>();
		for(int i = 0 ; i < n ; i++) {
			nset.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < m ; i++) {
			if(nset.contains(Integer.parseInt(st.nextToken()))) sb.append(1);
			else sb.append(0);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
