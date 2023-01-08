package DynamicPlanning2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Downhill3 {
	static int[][] arr;
	static int m;
	static int n;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		downhill(0,0);
		System.out.println(count);
	}
	private static void downhill(int i, int j) {
		if(i == m - 1 && j == n - 1) {
			count++;
			return ;
		}
		else if(i < m && j < n){
			if(i + 1 < m && arr[i][j] > arr[i+1][j]) {
				downhill(i+1,j);
			}
			if(j + 1 < n && arr[i][j] > arr[i][j+1]) {
				downhill(i,j+1);
			}
			if(i > 0 && arr[i][j] > arr[i-1][j]) {
				downhill(i-1,j);
			}
			if(j > 0 && arr[i][j] > arr[i][j-1]) {
				downhill(i,j-1);
			}
		}
		
		return ;
	}
}
