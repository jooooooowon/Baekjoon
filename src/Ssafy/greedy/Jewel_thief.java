package Ssafy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jewel_thief {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer[]> list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			list.add(arr);
		}
		int[] bags = new int[k];
		for(int i = 0 ; i < k ; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		Collections.sort(list, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		long result = 0;
		int j = 0;
		for(int i = 0 ; i < k; i++) {
			while(j < n && bags[i] >= list.get(j)[0]) {
				que.add(list.get(j)[1]);
				j++;
			}
			if(!que.isEmpty()) {
				result += que.poll();
			}
		}
		System.out.println(result);
	}

}
