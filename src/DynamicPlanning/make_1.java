package DynamicPlanning;

import java.util.Scanner;

public class make_1 {
	static Integer[] temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		temp = new Integer[n + 1];
		temp[1] = 0;
		System.out.println(Make_num_1(n));
		
		
	}

	private static int Make_num_1(int n) {
		if(temp[n] == null) {
			if(n % 6 == 0) {
				return temp[n] = Math.min(Make_num_1(n/3),Math.min(Make_num_1(n/2), Make_num_1(n - 1))) + 1;
			}
			else if(n % 3 == 0) {
				return temp[n] = Math.min(Make_num_1(n/3),Make_num_1(n - 1)) + 1;
			}
			else if(n % 2 == 0) {
				return temp[n] = Math.min(Make_num_1(n/2),Make_num_1(n - 1)) + 1;
			}
			else{
				return temp[n] = Make_num_1(n - 1) + 1;
			}
		}
		return temp[n];
	}

}
