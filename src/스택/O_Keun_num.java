package Ω∫≈√;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class O_Keun_num {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		int[] temp = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(arr[n-1]);
		temp[n-1] = -1;
		for(int i = n - 2 ; i >= 0 ; i--) {
			while(true) {
				if(stack.isEmpty()) {
					temp[i] = -1;
					stack.push(arr[i]);
					break ;
				}
				else if(arr[i] < stack.peek()) {
					temp[i] = stack.peek();
					stack.push(arr[i]);
					break ;
				}
				else {
					stack.pop();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(temp[i] + " ");
		}
		System.out.println(sb);
	}

}
