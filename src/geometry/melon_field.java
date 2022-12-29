package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class melon_field {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[6][2];
		for(int i = 0 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int width_max = 0;
		int height_max = 0;
		int rem_height = 0;
		int small_width = 0;
		int small_height = 0;
		for(int i = 0 ; i < 6; i++) {
			if(arr[i][0] == 1 || arr[i][0] == 2) {
				width_max = Math.max(width_max, arr[i][1]);
			}
			else {
				height_max = Math.max(height_max, arr[i][1]);
				if(height_max == arr[i][1]) {
					rem_height = i;
				}
			}
		}
		int i = rem_height + 1;
		if(i == 6) i = 0;
		if(arr[i][1] == width_max) {
			i += 2;
			if(i == 6) i = 0; if(i == 7) i = 1;
			small_width = arr[i][1];
			i++;
			if(i == 6) i = 0;
			small_height = arr[i][1];
		}
		else {
			i++;
			if(i == 6) i = 0;
			small_height = arr[i][1];
			i++;
			if(i == 6) i = 0;
			small_width = arr[i][1];
		}
		int result = n * (width_max * height_max - small_width * small_height);
		System.out.println(result);
		
	
	}

}
