package CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_reminder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n + 1];
		long[] temp = new long[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}
		
		for(int i = 1 ; i <= n; i++) {
			long j = arr[i] % m;
			temp[(int)j]++;
		}
		long count = 0;
		for(int i = 0; i < m ; i++) {
			count += (temp[i] * (temp[i] - 1)) / 2;
		}
		count += temp[0];
		System.out.println(count);
	}

}
