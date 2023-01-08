package DevideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Largest_rectangle_in_histogram {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			int[] arr = new int[n];
			Stack<Integer> stack = new Stack<>();
			long max = 0;
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0 ; i < n ; i++) {
				while((!stack.isEmpty()) && arr[stack.peek()] >= arr[i]) {
					int height = arr[stack.pop()];
					long width;
					if(stack.isEmpty()) width = i;		
					else width = i - 1 - stack.peek();
					max = Math.max(max, height * width);
				}
				stack.push(i);
			}
			while(!stack.isEmpty()) {
				int height = arr[stack.pop()];
				long width;
				if(stack.isEmpty()) width = n;
				else width = n - stack.peek() - 1;
				max = Math.max(max, height * width);
			}
			System.out.println(max);
		}
		
	}

}
