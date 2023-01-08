package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_distance2 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][3];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i < n ; i++) {
			arr[i][0] += Math.min(arr[i - 1][1],arr[i - 1][2]);
			arr[i][1] += Math.min(arr[i - 1][0],arr[i - 1][2]);
			arr[i][2] += Math.min(arr[i - 1][0],arr[i - 1][1]);
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(min > arr[n - 1][i]) min = arr[n - 1][i];
		}
		System.out.println(min);
	}
}
