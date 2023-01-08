package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N_and_M_3 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		for(int i = 1 ; i <= n ; i++) {
			arr[0] = i;
			N_and_M(n, m, arr, 1);
		}
		bw.flush();
		bw.close();
	}

	private static void N_and_M(int n, int m, int[] arr, int i) throws IOException {
		if(i == m) {
			for(int j = 0 ; j < m ; j++) {
				bw.write(arr[j] + " ");
			}
			bw.write("\n");
			return;
		}
		for(int j = arr[i - 1]; j <= n; j++) {
			arr[i] = j;
			N_and_M(n, m, arr, i + 1);
		}
		
		return ;
	}

}
