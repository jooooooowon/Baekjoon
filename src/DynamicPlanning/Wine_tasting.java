package DynamicPlanning;

import java.util.Scanner;

public class Wine_tasting {
	static int[] arr;
	static Integer[] temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		temp = new Integer[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = sc.nextInt();
		}
		temp[0] = arr[0];
		temp[1] = arr[1];
		if(n == 1) {
			System.out.println(temp[1]);
		}
		else {
			temp[2] = arr[1] + arr[2];
			System.out.println(tasting(n));
		}
	}
	private static int tasting(int i) {
		if(temp[i] == null) {
			temp[i] = Math.max(tasting(i - 2) + arr[i] ,Math.max(tasting(i - 3) + arr[i] + arr[i - 1],tasting(i - 1)));
		}
		return temp[i];
	}

}
