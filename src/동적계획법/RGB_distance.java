package µ¿Àû°èÈ¹¹ý;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_distance {
	static int n;
	static int[][] arr;
	static int[] temp = new int[3];
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
		temp[0] = arr[0][0];
		temp[1] = arr[0][1];
		temp[2] = arr[0][2];
		RGB_Distance(0, 0, 1);
		RGB_Distance(1, 1, 1);
		RGB_Distance(2, 2, 1);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3 ; i++) {
			if(min > temp[i]) min = temp[i];
		}
		System.out.println(min);
	}

	private static void RGB_Distance(int start_point, int pre, int j) {
		if(j == n) return;
		
		int min = Integer.MAX_VALUE;
		int awhile = -1;
		for(int i = 0 ; i < 3 ; i++) {
			if(i != pre) {
				if(min > arr[j][i]) {
					min = arr[j][i];
					awhile = i;
				}
			}
		}
		temp[start_point] += min;
		RGB_Distance(start_point, awhile, j + 1);
	}
		

}
