package DynamicPlanning;

import java.util.Scanner;

public class padovan {
	static long[] arr_odd = new long[101];
	static long[] arr_even = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		arr_odd[0] = 0;
		arr_odd[1] = 1;
		arr_odd[2] = 1;
		arr_odd[3] = 2;
		arr_even[0] = 0;
		arr_even[1] = 1;
		arr_even[2] = 2;
		for(int i = 0 ; i < test_case ; i++) {
			int n = sc.nextInt();
			triangle(n, 3, 2);
		}
	}
	private static void triangle(int n, int odd, int even) {
		int temp = odd + even;
		if(n <= 5) {
			if(n % 2 == 0) System.out.println(arr_even[n/2]);
			else System.out.println(arr_odd[n/2 + 1]);
			return ;
		}
		else if(temp == n) {
			if(temp % 2 == 0) System.out.println(arr_even[even]);
			else System.out.println(arr_odd[odd]);
			return ;
		}
		else if(temp % 2 == 1) {
			arr_even[even + 1] = arr_odd[odd] + arr_odd[odd - 2];
			triangle(n, odd, even + 1);
		}
		else {
			arr_odd[odd + 1] = arr_even[even] + arr_even[even - 2];
			triangle(n, odd + 1, even);
		}
		return ;
	}

}
