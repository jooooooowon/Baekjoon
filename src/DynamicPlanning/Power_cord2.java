package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Power_cord2 {
	static int[] arr = new int[501];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] temp = new int[n + 1];
		int[] temp_1 = new int[n + 1];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			arr[j] = Integer.parseInt(st.nextToken());
		}
		int count = 1;
		
		for(int i = 0; i < 501; i++) {
			if(count == n + 1) break;
			if(arr[i] > 0) {
				temp[count] = arr[i];
				count++;
			}
		}
		for(int i = 1 ; i < n + 1; i++) {
			temp_1[i] = 1;
			for(int j = 1; j < i; j++) {
				if(temp[i] > temp[j] && temp_1[i] < temp_1[j] + 1) {
					temp_1[i]++;
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n + 1; i++) {
			if(max < temp_1[i]) max = temp_1[i];
		}
		
		System.out.println(n - max);
	}

}
