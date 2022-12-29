package 브루트포스;

import java.util.Scanner;

public class repaint_chessboard4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		String[] str = new String[x];
		for(int i = 0 ; i < x ; i++) {
			str[i] = sc.next();
		}
		boolean[][] chk = new boolean[x][y];
		for(int i = 0; i < x ; i++) {
			for(int j = 0 ; j < y ; j++) {
				if(str[i].charAt(j) == 'W') chk[i][j] = true;
				else chk[i][j] = false;
			}
		}
		int result = 64;
		for(int i = 0; i < x - 7 ; i++) {
			for(int j = 0 ; j < y - 7 ; j++) {
				result = Math.min(repaint_chessboard(chk ,str, i, j), result);
			}
		}
		System.out.println(result);
	}

	private static int repaint_chessboard(boolean[][] chk, String[] str, int x, int y) {
		int count = 0;
		boolean ft = chk[x][y];
		
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				if(ft != chk[i][j]) count++;
				ft = !ft;
			}
			ft = !ft;
		}
		
		count = Math.min(count, 64 - count);
		return count;
	}

}
