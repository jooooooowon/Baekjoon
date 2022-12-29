package silver.silver5;

import java.util.Scanner;

public class Bar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 64) System.out.println(1);
		else {
			
			int bar = 64;
			int result = 0;
			int count = 0;
			while(result != n) {
				int temp = bar/2;
				if(result + temp > n) bar = temp;
				else {
					bar = temp;
					result += bar;
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
