package Ω∫≈√2;

import java.util.Scanner;
import java.util.Stack;

public class Reunited_oasis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		long count = 0;
		Stack<Integer[]> stack = new Stack<>();		// 0 = height , 1 = cnt
		for(int i = 0 ; i < n; i++) {
			Integer[] temp = new Integer[2];
			temp[0] = arr[i];
			temp[1] = 1;
			while(!stack.empty() && stack.peek()[0] <= arr[i]) {
				Integer[] temp_pop = stack.pop();
				count += temp_pop[1];
				if(temp_pop[0] == arr[i]) temp[1] += temp_pop[1];
			}
			if(!stack.empty()) count++;
			stack.add(temp);
		}
		System.out.println(count);
	}

}
