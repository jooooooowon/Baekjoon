package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class turret {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][6];									// (0) = x1, (1) = y1, (2) = r1, (3) = x2, (4) = y2, (5) = r2
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 6 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < n ; i++) {
			int distance = (int)(Math.pow(arr[i][0] - arr[i][3], 2) + Math.pow(arr[i][1] - arr[i][4], 2));
			if(arr[i][0] == arr[i][3] && arr[i][1] == arr[i][4] && arr[i][2] == arr[i][5]) sb.append(-1 + "\n");
			else if(distance > Math.pow(arr[i][2] + arr[i][5], 2)) sb.append(0 + "\n");
			else if(distance == Math.pow(arr[i][2] + arr[i][5], 2) || distance == Math.pow(arr[i][2] - arr[i][5], 2)) sb.append(1 + "\n");
			else if(distance > Math.pow(arr[i][2] - arr[i][5],2)) sb.append(2 + "\n");
			else sb.append(0 + "\n");
		}
		System.out.println(sb);
	}
}
