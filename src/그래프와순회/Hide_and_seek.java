package 그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_and_seek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(n == k) {
			System.out.println(0);
			System.exit(0);
		}
		int[] arr = new int[200000];
		arr[n] = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(n);
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(temp - 1 >= 0) {
				if(arr[temp-1] == 0) {
					arr[temp-1] = arr[temp] + 1;
					que.offer(temp-1);
				}
			}
			if(temp + 1 < 2*k) {
				if(arr[temp+1] == 0) {
					arr[temp+1] = arr[temp] + 1;
					que.offer(temp+1);
				}
			}
			if(temp * 2 < 2*k) {
				if(arr[temp*2] == 0) {
					arr[temp*2] = arr[temp] + 1;
					que.offer(temp*2);
				}
			}
		}
		System.out.println(arr[k]);
	}

}
