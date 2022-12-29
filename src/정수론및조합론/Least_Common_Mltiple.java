package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Least_Common_Mltiple {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(Least_Common_Mltiple(a,b));
		}
	}

	private static int Least_Common_Mltiple(int a, int b) {
		int result;
		int i = 1;
		while(true) {
			result = Math.max(a, b);
			result *= i;
			if(result % a == 0 && result % b == 0) break;
			i++;
		}
		return result;
	}

}
