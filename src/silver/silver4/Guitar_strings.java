package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guitar_strings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int price = Integer.MAX_VALUE;
		for(int i = 0 ; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int bundle = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int temp = 0;
			do {
				if(n/6 > 0) {
					if(bundle < one * 6) temp += bundle;
					else temp += one * 6;
					n /= 6;
				}
				else {
					if(bundle < one * n) temp += bundle;
					else temp += one * n;
				}
				
			} while(n/6 > 0);
			price = Math.min(price,temp);
		}
		System.out.println(price);
	
	}

}
