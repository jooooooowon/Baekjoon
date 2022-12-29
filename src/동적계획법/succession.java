package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class succession {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] temp = new int[n];
		temp[0] = arr[0];
		int max = temp[0];
		for(int i = 1; i < n ; i++) {
			temp[i] = Math.max(temp[i - 1] + arr[i], arr[i]);
			max = Math.max(temp[i], max);
		}
		
		System.out.println(max);
	}

}
