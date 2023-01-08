package Stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class R_big_number_using_map {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp_stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(st.nextToken());
			stack.add(num);
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			int temp = map.get(stack.peek());
			while(!temp_stack.isEmpty() && map.get(temp_stack.peek()) <= temp) {
				temp_stack.pop();
			}
			if(temp_stack.isEmpty()) sb.insert(0,-1+" ");
			else sb.insert(0,temp_stack.peek()+" ");
			temp_stack.add(stack.pop());
		}
		System.out.println(sb);
	}

}
