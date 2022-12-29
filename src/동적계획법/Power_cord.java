package µ¿Àû°èÈ¹¹ý;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Power_cord {
	static int[] arr = new int[501];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] temp_1 = new int[n + 1];
		int[] temp_2 = new int[n + 1];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			arr[j] = Integer.parseInt(st.nextToken());
		}
		temp_1[0] = 0;
		int count = 1;
		
		for(int i = 1 ; i < 501; i++) {
			if(count == n + 1) break;
			else if(arr[i] > 0) {
				temp_1[count] = temp_1[count - 1];
				for(int j = 1; j < i; j++) {
					if(arr[i] < arr[j] && arr[j] > 0) {
						temp_1[count]++;
						break ;
					}
				}
				count++;
			}
		}
		temp_2[0] = 0;
		count = 1;
		for(int i = 500 ; i >= 1; i--) {
			if(count == n + 1) break;
			else if(arr[i] > 0) {
				temp_2[count] = temp_2[count - 1];
				for(int j = 500; j > i; j--) {
					if(arr[i] > arr[j] && arr[j] > 0) {
						temp_2[count]++;
						break ;
					}
				}
				count++;
			}
		}
		
		System.out.println(Math.min(temp_1[n], temp_2[n]));
	}

}
