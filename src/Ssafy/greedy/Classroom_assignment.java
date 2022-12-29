package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Classroom_assignment {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		ArrayList<Integer[]> list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			list.add(arr);
		}
		Collections.sort(list, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> endque = new PriorityQueue<>();
		endque.offer(list.get(0)[1]);
		for(int i = 1 ; i < list.size(); i++) {
			if(list.get(i)[0] >= endque.peek()) {
				endque.poll();
			}
			endque.offer(list.get(i)[1]);
		}
		System.out.println(endque.size());
	}

}
