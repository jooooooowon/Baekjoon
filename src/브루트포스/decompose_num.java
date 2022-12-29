package 브루트포스;

import java.util.Scanner;

public class decompose_num {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(decompose_num(n));
	}

	private static int decompose_num(int n) {
		int	make ;
		int chk;
		int result = 0;
		for(make = 0; make < n ; make++) {
			chk = make;
			result = 0;
			do {
				result += chk % 10;
				chk /= 10;
			} while(chk != 0);
			result += make;
			if(result == n) break;
		}
		if(result == n) return make;
		else return 0;
	}

}
