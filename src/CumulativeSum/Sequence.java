package CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i <= n - m ; i++) {
			int temp = 0;
			for(int j = i; j < i + m; j++) {
				temp += arr[j];
			}
			list.add(temp);
		}
		System.out.println(Collections.max(list));
		
	}

}
