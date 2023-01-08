package DynamicPlanning;

import java.util.Scanner;

public class tile_01 {
	static int[] arr = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr[0] = 1; arr[1] = 1;
		for(int i = 2; i <= n ; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
		}
		System.out.println(arr[n]);
	}

}
