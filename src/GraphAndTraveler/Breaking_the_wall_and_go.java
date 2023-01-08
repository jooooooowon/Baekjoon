package GraphAndTraveler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Breaking_the_wall_and_go {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(n == 1 && m == 1) {
			System.out.println(1);
			System.exit(0);
		}
		boolean[][] chkT = new boolean[n][m];
		boolean[][] chkF = new boolean[n][m];
		int[][] count = new int[n][m];
		int[][] arr = new int[n][m];
		count[0][0] = 1;
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
				chkT[i][j] = true;
				chkF[i][j] = true;
			}
		}
		
		PriorityQueue<Integer> pQue = new PriorityQueue<>();
		
		chkT[0][0] = false;
		chkF[0][0] = false;
		Queue<You> que = new LinkedList<You>();

		int[] xDir = {1,-1,0,0};
		int[] yDir = {0,0,1,-1};
		que.add(new You(true,0,0));
		
		while(!que.isEmpty()) {
			You temp = que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int tempX = temp.x + xDir[i];
				int tempY = temp.y + yDir[i];
				if(tempY < n && tempY >= 0 && tempX < m && tempX >= 0 ) {
					if(temp.breaking) {
						if(chkT[tempY][tempX]) {
							if(arr[tempY][tempX] == 1) {
								que.add(new You(false,tempY,tempX));
								chkT[tempY][tempX] = false;
							}
							else if(arr[tempY][tempX] == 0) {
								que.add(new You(true,tempY,tempX));
								chkT[tempY][tempX] = false;
							}
						}
					}
					else {
						if(chkF[tempY][tempX]) {
							if(arr[tempY][tempX] == 0) {
								que.add(new You(false,tempY,tempX));
								chkF[tempY][tempX] = false;
							}
						}
					}
					count[tempY][tempX] = count[temp.y][temp.x]+1;
					if(tempY == n-1 && tempX == m-1) pQue.add(count[tempY][tempX]);
				}
			}
		}
		if(!chkF[n-1][m-1] || !chkT[n-1][m-1]) System.out.println(pQue.poll());
		else System.out.println(-1);

	}
}

class You{
	boolean breaking;
	int x;
	int y;
	
	You(boolean breaking, int y, int x){
		this.breaking = breaking;
		this.x = x;
		this.y = y;
	}
	
}
