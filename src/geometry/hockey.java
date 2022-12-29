package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hockey {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		double r = h/2;
		int[][] arr = new int[p][2];
		for(int i = 0; i < p ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); 
			arr[i][1] = Integer.parseInt(st.nextToken()); 
		}
		int count = 0;
		for(int i = 0 ; i < p ; i++) {
			int distance1 = (int)(Math.pow(arr[i][0] - x, 2) + Math.pow(arr[i][1] - (y + r), 2));
			int distance2 = (int)(Math.pow(arr[i][0] - (x + w), 2) + Math.pow(arr[i][1] - (y + r), 2));
			if(arr[i][0] >= x && arr[i][0] <= x + w && arr[i][1] >= y && arr[i][1] <= y + h) count++;
			else if(arr[i][0] < x) {
				if(distance1 <= Math.pow(r, 2)) count++;
			}
			else{
				if(distance2 <= Math.pow(r, 2)) count++;
			}
		}
		System.out.println(count);
	}

}
