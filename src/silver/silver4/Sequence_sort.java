package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sequence_sort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		boolean[] chk = new boolean[n];
		int[] p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			a[i] = temp;
			b[i] = temp;
			p[i] = -1;
		}
		Arrays.sort(b);
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(a[i] == b[j]) {
					if(!chk[j]) {
						p[i] = j;
						chk[j] = true;
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(p[i] + " ");
		}
		System.out.println(sb);
	}

}
