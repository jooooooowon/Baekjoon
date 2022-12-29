package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_marbles {
	//플로이드 와샬 = 모든 정점에서 모든 정점까지 가는 최단 거리 구하기 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		int half = n/2 + 1;
		for(int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());
			arr[heavy][light] = 1;
			arr[light][heavy] = -1;
		}
		for(int i = 1; i <= n ; i++) {				// 거쳐점
			for(int j = 1; j <= n; j++) {			// 시작점				모든 정점에서 모든 정점까지 최다 거리를 구하는 플로이드 와샬을 이용한 방법
				for(int k = 1; k <= n; k++) {		// 도착점
					if(arr[i][k] != 0 && arr[j][i] == arr[i][k]) arr[j][k] = arr[j][i];
				}
			}
		}
		int[] big = new int[n+1];
		int[] small = new int[n+1];
	
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n ; j++) {
				if(arr[i][j] == 1) big[i]++;
				else if(arr[i][j] == -1) small[i]++;
			}
		}
		int result = 0;
		for(int i = 1; i <= n ; i++) {
			if(big[i] >= half) result++;
			else if(small[i] >= half) result++;
		}
		System.out.println(result);
	}

}
