package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Interleave_operator {
	static int min = 1000000000;
	static int max = -1000000000;
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		map.put("+", Integer.parseInt(st.nextToken())); // +
		map.put("-", Integer.parseInt(st.nextToken())); // -
		map.put("*", Integer.parseInt(st.nextToken())); // *
		map.put("/", Integer.parseInt(st.nextToken())); // /
		int result = arr[0];
		Interleave_operator(arr, 1, n, result);
		
		System.out.print(max + "\n" + min);
	}

	private static void Interleave_operator(int[] arr, int i, int n, int result) {
		if(i == n) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		for(String str : map.keySet()) {
			int temp = result;
			if(map.get(str) > 0) {
				if(str == "+") {
					result += arr[i];
				}
				else if(str == "-") {
					result -= arr[i];
				}
				else if(str == "*") {
					result *= arr[i];
				}
				else if(str == "/") {
					result /= arr[i];
				}
				map.put(str, map.get(str) - 1);
				Interleave_operator(arr, i + 1, n, result);
				map.put(str, map.get(str) + 1);
				result = temp;
			}
		}		

		return ;
	}

}






