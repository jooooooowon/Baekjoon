package QueueAndDque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class AC {

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
			str = br.readLine();
			if(n == 0) sb.append("error\n");
			else{
				
				str = str.replace("[", "");
				str = str.replace("]", "");
			
				Deque<Integer> D = new ArrayDeque<>();
				Deque<Integer> R = new ArrayDeque<>();
				String[] temp = str.split(",");
				for(int j = 0 ; j < temp.length ; j++) {
					D.offer(Integer.parseInt(temp[j]));
				}
				
				
				boolean tf = true;
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j) == 'R') {
						if(R.isEmpty()) {
							while(!D.isEmpty()) {
							R.offer(D.pollLast());
							}
						}
						else {
							while(!R.isEmpty()) {
								D.offer(R.pollLast());
							}
						}
					}
					else if(list.get(j) == 'D') {
						if(!D.isEmpty()) {
							D.pollFirst();
						}
						else if(!R.isEmpty()) {
							R.pollFirst();
						}	
						else {
							tf = false;
							break ;
						}
					}
				}
				if(tf) {
					sb.append("[");
					if(!D.isEmpty()) {
						while(D.size() > 1) {
							sb.append(D.pollFirst()).append(",");
						}
						sb.append(D.pollFirst()).append("]\n");
					}
					else {
						while(R.size() > 1) {
							sb.append(R.pollFirst()).append(",");
						}	
						sb.append(R.pollFirst()).append("]\n");
					}	
				}
				else sb.append("error\n");
			}
		}
		System.out.println(sb);
	}
}
