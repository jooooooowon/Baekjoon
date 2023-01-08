package QueueAndDque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Rotating_queue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deq = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n ; i++) {
			deq.offer(i);
		}
		int count = 0;
		for(int i = 0 ; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int half;
			int index = deq.indexOf(temp);
			if(deq.size() % 2 == 0) half = deq.size()/2 - 1;
			else half = deq.size()/2;
			if(half >= index) {
				for(int j = 0 ; j < index ; j++) {
					deq.offerLast(deq.pollFirst());
					count++;
				}
			}
			else {
				for(int j = 0 ; j < deq.size() - index; j++) {
					deq.offerFirst(deq.pollLast());
					count++;
				}
			}
			deq.pollFirst();
		}
		System.out.println(count);
	}

}
