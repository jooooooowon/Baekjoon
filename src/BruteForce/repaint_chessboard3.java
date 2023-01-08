package BruteForce;

import java.util.Scanner;

public class repaint_chessboard3 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		String[] str = new String[x];
		for(int i = 0 ; i < x ; i++) {
			str[i] = sc.next();
		}
		String[] case_1 = new String[8];
		for(int i = 0 ; i < 8 ; i += 2) {
			case_1[i] = "BWBWBWBW";
			case_1[i + 1] = "WBWBWBWB";
		}
		String[] case_2 = new String[8];
		for(int i = 0 ; i < 8 ; i += 2) {
			case_2[i] = "WBWBWBWB";
			case_2[i + 1] = "BWBWBWBW";
		}
		int result = 64;
		for(int i = 0 ; i < x - 7 ; i++) {
			for(int j = 0 ; j < y - 7 ; j++) {
				result = Math.min(repaint_chessboard(str, i, j, case_1), result);
			}
		}
		for(int i = 0 ; i < x - 7 ; i++) {
			for(int j = 0 ; j < y - 7 ; j++) {
				result = Math.min(repaint_chessboard(str, i, j, case_2), result);
			}
		}
		System.out.println(result);
	}

	private static int repaint_chessboard(String[] str, int x, int y, String[] cases) {
		int count = 0;
		for(int j = x; j < x + 8 ; j++) {
			for(int i = y ; i < y + 8; i++) {
				if(str[j].charAt(i) != cases[j - x].charAt(i - y)) count++;
			}
		}
		return count;
	}
}
