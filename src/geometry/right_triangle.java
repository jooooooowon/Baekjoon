package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class right_triangle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[3];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());
			if(temp[0] == 0 && temp[1] == 0 && temp[2] == 0) {
				break;
			}	
			else {
				if(Math.pow(temp[0], 2) + Math.pow(temp[1], 2) == Math.pow(temp[2], 2) || Math.pow(temp[0], 2) + Math.pow(temp[2], 2) == Math.pow(temp[1], 2) 
						|| Math.pow(temp[2], 2) + Math.pow(temp[1], 2) == Math.pow(temp[0], 2)) {
					sb.append("right" + "\n");
				}
				else sb.append("wrong" + "\n");
			}
		}
		System.out.println(sb);
	}
}
