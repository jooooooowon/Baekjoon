package Å¥¿Íµ¦;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Printer_queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < test_case ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Queue<Integer> que = new LinkedList<>();
			Queue<Integer> order = new LinkedList<>();
			Integer[] arr = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				int num =Integer.parseInt(st.nextToken());
				que.offer(num);
				order.offer(j);
				arr[j] = num;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			int count = 0;
			int j = 0;
			while(true) {
				if(arr[j] == que.peek()) {
					que.poll();
					count++;
					if(order.peek() == m) {
						sb.append(count).append("\n");
						break;
					}
					order.poll();
					j++;
				}
				else {
					que.offer(que.poll());
					order.offer(order.poll());
				}
				
			}
		}
		System.out.println(sb);
		
	}

}
