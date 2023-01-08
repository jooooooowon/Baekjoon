package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Interleave_operator2 {
	static int min = 1000000000;
	static int max = -1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] list = new int[4];
		list[0] = Integer.parseInt(st.nextToken()); // +
		list[1] = Integer.parseInt(st.nextToken()); // -
		list[2] = Integer.parseInt(st.nextToken()); // *
		list[3] = Integer.parseInt(st.nextToken()); // /
		int result = arr[0];
		Interleave_operator(arr, list, 1, n, result);
		
		System.out.print(max + "\n" + min);
	}

	private static void Interleave_operator(int[] arr, int[] list, int i, int n, int result) {
		if(i == n) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		for(int str = 0 ; str < 4 ; str++) {
			if(list[str] > 0) {
				int temp = result;
				if(str == 0) {
					result += arr[i];
				}
				else if(str == 1) {
					result -= arr[i];
				}
				else if(str == 2) {
					result *= arr[i];
				}
				else if(str == 3) {
					result /= arr[i];
				}
				list[str]--;
				Interleave_operator(arr, list, i + 1, n, result);
				list[str]++;
				result = temp;
			}
		}		

		return ;
	}

}






