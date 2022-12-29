package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int case_count= 1;
		
		while(true) {
			if(l == 0 && p == 0 && v == 0) break ;
			int day = 0;
			while(v > 0) {
				if(l <= v) {
					day += l;
					v -= p;
				}
				else {
					day += v;
					v = 0;
				}
			}
			sb.append("Case "+case_count+": "+day+"\n");
			case_count++;
			
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb);
	}

}
