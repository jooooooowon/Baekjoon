package DynamicPlanning;

import java.util.Scanner;

public class Climbing_stairs {
	static Integer[] temp;
	static int[] arr; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		temp = new Integer[n + 1];
		for(int i = 1; i < n + 1; i++) {
			arr[i] = sc.nextInt();
		}
		temp[0] = arr[0];
		System.out.println(climbing(n));
	}

	private static int climbing(int stair) {
		if(stair <= 0) {
			return temp[0];
		}
		if(temp[stair] == null) {
			temp[stair] = Math.max(arr[stair - 1] + climbing(stair - 3) + arr[stair] ,climbing(stair - 2) + arr[stair]);
			return temp[stair];
		}
		return temp[stair];
		
	}

}
