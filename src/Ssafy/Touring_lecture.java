package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Touring_lecture {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println(0);
			System.exit(0);
		}
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		int[][] arr = new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[i][0] = p;
			arr[i][1] = d;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 0 ; i < n ; i++) {
			int day = arr[i][1];
			pque.add(arr[i][0]);
			while(day < pque.size()) pque.remove();
		}
		int result = 0;
		while(!pque.isEmpty()) result += pque.poll();
		System.out.println(result);
	}
	
}
