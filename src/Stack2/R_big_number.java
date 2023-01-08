package Stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
// stack¿¡ index ´ã±â
public class R_big_number {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			input[i] = temp;
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		for(int i = 0 ; i < n ; i++) {
			while(!stack.isEmpty() && map.get(input[stack.peek()]) < map.get(input[i])) {
				ans[stack.pop()] = input[i];
			}
			stack.add(i);
		}
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
		
	}

}
