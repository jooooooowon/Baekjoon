package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Treasure {
	static int[] a;
	static int[] b;
	static int[] c;
	static boolean[] chk;
	static int n;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		c = new int[n];
		chk = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		min = 0;
		for(int i = 0 ; i < n ; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			min += b[i] * a[i];
		}
		
		make_min(0, 0);
		System.out.println(min);
	}

	private static void make_min(int temp, int idx) {
		if(min <= temp) {
			return ;
		}
		else if(idx == n) {
			min = temp;
			return ;
		}
		for(int i = 0 ; i < n ; i++) {
			if(!chk[i]) {
			c[idx] = a[i];
			temp += c[idx] * b[idx];
			chk[i] = true;
			make_min(temp, idx + 1);
			temp -= c[idx] * b[idx];
			chk[i] = false;
			}
		}
		return ;
	}

}
