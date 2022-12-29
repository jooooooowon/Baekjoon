package Å¥¿Íµ¦;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < t ; i++) {
			ArrayList<Character> list = new ArrayList<>();
			String str = br.readLine();
			for(int j = 0 ; j < str.length() ; j++) {
				list.add(str.charAt(j));
			}
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			Deque<Integer> D = new ArrayDeque<>();
			for(int j = 0 ; j < n ; j++) {
				D.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean tf = true;
			int r = 0;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j) == 'R') r++;
				else if(list.get(j) == 'D') {
					if(D.isEmpty()) {
						sb.append("error\n");
						tf = false;
						break;
					}
					else if(r % 2 == 0) D.pollFirst(); 
					else D.pollLast(); 
				}
			}
			if(tf) {
				sb.append("[");
				if(D.isEmpty()) sb.append("]\n");
				else {
					if(r % 2 == 0) {
						while(D.size() > 1) {
							sb.append(D.pollFirst()).append(",");
						}
						sb.append(D.pollFirst()).append("]\n");
					}
					else {
						while(D.size() > 1) {
							sb.append(D.pollLast()).append(",");
						}
						sb.append(D.pollLast()).append("]\n");
					}
				}
			}
		}
		System.out.println(sb);

	}
}
