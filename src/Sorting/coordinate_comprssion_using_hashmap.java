package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class coordinate_comprssion_using_hashmap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int[n];
		int[] temp = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			temp[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(arr);
		int index = 0;
		for(int i : arr) {
			if(!map.containsKey(i)) {
				map.put(i, index);	
				index++;  
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : temp) {
			int result = map.get(i);
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}

}
