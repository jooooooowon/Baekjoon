package pluscycle;

import java.util.Scanner;

public class pluscycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(letplus(num));
	}

	private static int letplus(int num) {
		int a, b, result, count = 0;
		result = num;
		do {
			a = result / 10;
			b = result % 10;
			
			result = b * 10 + (a + b) % 10;
			count++;
		}while(result != num);
		
		return count;
	}

}
