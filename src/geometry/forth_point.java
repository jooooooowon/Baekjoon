package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class forth_point {

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[3][2];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 3 ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int x,y;
		if(arr[0][0] == arr[1][0]) x = arr[2][0];
		else if(arr[0][0] == arr[2][0]) x = arr[1][0];
		else x = arr[0][0];
		if(arr[0][1] == arr[1][1]) y = arr[2][1];
		else if(arr[0][1] == arr[2][1]) y = arr[1][1];
		else y = arr[0][1];
		System.out.printf("%d %d",x,y);

	}

}
