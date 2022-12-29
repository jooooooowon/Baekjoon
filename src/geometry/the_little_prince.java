package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class the_little_prince {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][4];
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());			//x1
			arr[i][1] = Integer.parseInt(st.nextToken());			//y1
			arr[i][2] = Integer.parseInt(st.nextToken());			//x2
			arr[i][3] = Integer.parseInt(st.nextToken());			//y2
			int m = Integer.parseInt(br.readLine());
			int count = 0;
			int[][] planet = new int[m][3];
			for(int j = 0 ; j < m ; j++) {
				st = new StringTokenizer(br.readLine());
				planet[j][0] = Integer.parseInt(st.nextToken());	//cx
				planet[j][1] = Integer.parseInt(st.nextToken());	//cy
				planet[j][2] = Integer.parseInt(st.nextToken());	//cr
				int distance1 = (int)(Math.pow(arr[i][0] - planet[j][0],2) + Math.pow(arr[i][1] - planet[j][1],2));  
				int distance2 = (int)(Math.pow(arr[i][2] - planet[j][0],2) + Math.pow(arr[i][3] - planet[j][1],2));  
				if(distance1 < Math.pow((int)planet[j][2], 2) || distance2 < Math.pow((int)planet[j][2], 2)) {
					if(!(distance1 < Math.pow((int)planet[j][2], 2) && distance2 < Math.pow((int)planet[j][2], 2))) count++;
			}
		}
			System.out.println(count);
	}

}
}