package ACM_Hotel;

import java.util.Scanner;

public class ACM_Hotel2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 0; i < test; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			int a = n % h, b =	n / h;
			if(a == 0) {
				System.out.printf("%d%02d\n",n,b);
			}
			else {
				System.out.printf("%d%02d\n",a,b + 1);
			}
		}
	}
}
