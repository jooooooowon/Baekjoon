package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Subin{
	int index;
	int time;
	public Subin(int index, int time) {
		this.index = index;
		this.time = time;
	}
}

public class HideAndSeek3 {

	public static void main(String[] args) throws IOException {
		//13549
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		
		int[] arr = new int[100001];
		boolean[] chk = new boolean[100001];
		chk[n] = true;
		PriorityQueue<Subin> que = new PriorityQueue<>((o1,o2) -> o1.time - o2.time);
		que.add(new Subin(n,0));
		while(!que.isEmpty()) {
			Subin temp = que.poll();
			int mult = temp.index*2;
			int plus = temp.index + 1;
			int minus = temp.index - 1;
			if(mult < 100001 && (!chk[mult] || arr[mult] > temp.time)) {
				chk[mult] = true;
				int time = temp.time;
				arr[mult] = time;
				que.add(new Subin(mult,time));
			}
			if(plus < 100001 && !chk[plus]) {
				chk[plus] = true;
				int time = temp.time+1;
				arr[plus] = time;
				que.add(new Subin(plus,time));
			}
			if(minus >= 0 && !chk[minus]) {
				chk[minus] = true;
				int time = temp.time+1;
				arr[minus] = time;
				que.add(new Subin(minus,time));
			}
			
		}
		System.out.println(arr[k]);
	}

}
