package 정수론및조합론;

import java.util.Scanner;

public class Greatest_Common_Factor_and_Least_Common_Multiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = n , b = m;
		int factor = 1;
		int i = 2;
		while(i <= Math.min(n, m)) {
			if(n % i == 0 && m % i == 0) {
				factor *= i;
				n /= i;
				m /= i;
			}
			else i++;
		}
		int multiple; 
		i = 1;
		while(true) {
			multiple = factor;
			multiple *= i;
			if(multiple % a == 0 && multiple % b == 0) break;
			i++;
		}
		System.out.println(factor);
		System.out.println(multiple);
	}

}
