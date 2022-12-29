package Å¥¿Íµ¦;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push" :{ 
					int num = Integer.parseInt(st.nextToken());
					queue.offer(num);
					break ;
				}
				case "pop" :{
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else {
						sb.append(queue.peek() + "\n");
						queue.poll();
						}
					break ;
				}
				case "size":{
					sb.append(queue.size()+ "\n");
					break ;
				}
				case "empty":{
					if(queue.isEmpty()) sb.append(1 + "\n");
					else sb.append(0+ "\n");
					break ;
				}
				case "front":{
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else sb.append(queue.peek() + "\n");
					break ;
				}
				case "back":{
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else sb.append(queue.peekLast() + "\n");
					break ;
				}
			}
		}
		System.out.println(sb);
	}
}
