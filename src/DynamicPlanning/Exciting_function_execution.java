package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exciting_function_execution {
	static int[][][] temp = new int[21][21][21];
	static int a, b, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			w(a,b,c);
			if (a == -1 && b == -1 && c == -1) break;
			System.out.printf("w(%d, %d, %d) = %d\n", a, b , c, w(a,b,c));
		}
		
	}

	private static int w(int a, int b, int c) {
		if(a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && temp[a][b][c] != 0) {
			return temp[a][b][c];
		}
		else if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if(a > 20 || b > 20 || c > 20) {
			a = 20; b = 20; c = 20;
			return temp[20][20][20] = w(a ,b ,c);
		}
		else if(a < b && b < c) {
			return temp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a ,b - 1 ,c) ;
		}
		else {
			return temp [a][b][c] = w(a - 1, b, c) + w(a - 1 ,b - 1 ,c) +  w(a - 1 ,b ,c - 1) - w(a - 1,b - 1,c - 1); 
		}
	}

}
