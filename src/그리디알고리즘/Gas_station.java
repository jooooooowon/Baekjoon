package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gas_station {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] distance = new long[n - 1];
		long[] cities = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n - 1; i++) {
			cities[i] = Long.parseLong(st.nextToken());
		}
		Integer.parseInt(st.nextToken());
		cities[n-1] = 1000000001;
		long price = 0;
		long min = cities[0];
		for(int i = 0 ; i < n - 1; i++) {
			if(cities[i] < min) min = cities[i];
			price += distance[i] * min;
		}
		System.out.println(price);
	}

}
