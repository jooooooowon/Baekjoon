package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Start_and_link {
	static int[][] arr;
	static int n;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Set<Integer> set = new HashSet<>();
		find(set,1);
		System.out.println(result);
	}

	private static void find(Set set, int num) {
		if(set.size() == n/2){
			Set<Integer> temp_set = new HashSet<>();
			for(int i = 1; i <= n ; i++) {
				if(!set.contains(i)) temp_set.add(i);
			}
			Integer[] temp_arr1 = (Integer[]) set.toArray(new Integer[set.size()]);	
			Integer[] temp_arr2 = (Integer[]) temp_set.toArray(new Integer[set.size()]);	
			int temp_1 = 0;
			for(Integer a : temp_arr1) {
				for(Integer b : temp_arr1) {
					temp_1 += arr[a][b];
				}
			}
			int temp_2 = 0;
			for(Integer a : temp_arr2) {
				for(Integer b : temp_arr2) {
					temp_2 += arr[a][b];
				}
			}
			result = Math.min(result, Math.abs(temp_2 - temp_1));
			if(result == 0) {
				System.out.println(result);
				System.exit(0);
			}
			return ;
		}
		for(int i = num ; i <= n ; i++) {
			set.add(i);
			find(set, num + 1);
			set.remove(i);
		}
		return ;
	}

}
