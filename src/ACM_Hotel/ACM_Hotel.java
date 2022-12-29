package ACM_Hotel;

import java.util.Scanner;

public class ACM_Hotel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int[][] arr = new int[test][2];
		for(int i = 0; i < test; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			int a = n % h, b =	n / h;
			if(a == 0) {
				arr[i][0] = h;
				arr[i][1] = b;
			}
			else {
				arr[i][0] = a;
				arr[i][1] = b + 1;
			}
		}
		
		for(int i = 0; i < test; i++) {
			System.out.printf("%d%02d\n",arr[i][0],arr[i][1]);
		}
	}
}
