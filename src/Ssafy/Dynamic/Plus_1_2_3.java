package Ssafy.Dynamic;

import java.util.Scanner;

public class Plus_1_2_3 {
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++) {
			int n = sc.nextInt();
			count = 0;
			find(n,0);
			System.out.println(count);
		}
	}

	private static void find(int n, int result) {
		for(int i = 1 ; i <= 3 ; i++) {
			result += i;
			if(result < n) find(n,result);
			else if(result == n) {
				count++;
				return ;
			}
			result -= i;
		}
	}

}
