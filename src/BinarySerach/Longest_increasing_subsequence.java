package BinarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Longest_increasing_subsequence {
	static int[] arr;
	static ArrayList<Integer> temp = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		temp.add(0);
		for(int i = 1 ; i <= n; i++) {
			if(arr[i] > temp.get(temp.size() - 1)) temp.add(arr[i]);
			else fnd(i);
		}
		System.out.println(temp.size() - 1);
		
	}
	private static void fnd(int i) {
		int start = 1;
		int end = temp.size();
		while(start < end) {
			int mid = (start + end) / 2;
			if(temp.get(mid) >= arr[i]) end = mid;
			else start = mid + 1;
		}
		temp.set(start, arr[i]);
		
	}

}
