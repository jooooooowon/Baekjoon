package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class coordinate_comprssion {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i : arr) {
			set.add(i);
		}
		Stream<Integer> setS = set.stream();
		int[] newarr = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		for(int i = 0 ; i < newarr.length; i++) {
			newarr[i] = it.next();
		}
		
		Arrays.sort(newarr);
		
		int[] result = new int[n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < newarr.length ; j++) {
				if(newarr[j] == arr[i]) result[i] = j;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
	
}
