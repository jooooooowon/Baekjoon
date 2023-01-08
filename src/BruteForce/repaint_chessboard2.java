package BruteForce;

import java.util.Scanner;

public class repaint_chessboard2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		String[] arr = new String[y];
		for(int i = 0 ;i < y; i++) {
				arr[i] = sc.next();
		}
		int result = x * y;
		for(int i = 0; i <= y - 8; i++) {
			for(int j = 0 ; j <= x - 8; j++) {
				int num = repaint_chessboard(arr,j,i);				//좌측 상단
				if(result > num) result = num;
			}
		}
		int min = 64;
//		for(int i = y - 1; i >= 7; i--) {
//			for(int j = x - 1 ; j >= 7; j--) {
//				int num = reverse_repaint_chessboard(arr,j,i);		//우측 하단
//				if(result > num) result = num;
//			}
//		}
//		
		result = Math.min(result, min - result);
		System.out.println(result);
	}

	private static int repaint_chessboard(String[] arr, int x, int y) {
		int count = 0;
		if(arr[y].charAt(x) == 'W') {
			if((x + y) % 2 == 1) {
				for(int i = y; i <= y + 7; i++) {
					for(int j = x ; j <= x + 7; j++) {
						if((j + i) % 2 == 0 && arr[i].charAt(j) == arr[y].charAt(x)) count++; 
						else if((j + i) % 2 == 1 && arr[i].charAt(j) != arr[y].charAt(x)) count++;
					}
				}
			}
			else {
				for(int i = y; i <= y + 7; i++) {
					for(int j = x ; j <= x + 7; j++) {	
						if((j + i) % 2 == 0 && arr[i].charAt(j) != arr[y].charAt(x)) count++; 
						else if((j + i) % 2 == 1 && arr[i].charAt(j) == arr[y].charAt(x)) count++;
					}
				}
			}
		}
		else {
			count++;
			if((x + y) % 2 == 1) {
				for(int i = y; i <= y + 7; i++) {
					for(int j = x ; j <= x + 7; j++) {
						if((j + i) % 2 == 0 && arr[i].charAt(j) == arr[y].charAt(x)) count++; 
						else if((j + i) % 2 == 1 && arr[i].charAt(j) != arr[y].charAt(x)) count++;
					}
				}
			}
			else {
				for(int i = y; i <= y + 7; i++) {
					for(int j = x ; j <= x + 7; j++) {	
						if((j + i) % 2 == 0 && arr[i].charAt(j) != arr[y].charAt(x)) count++; 
						else if((j + i) % 2 == 1 && arr[i].charAt(j) == arr[y].charAt(x)) count++;
					}
				}
			}
		}
		return count;
	}
	
	private static int reverse_repaint_chessboard(String[] arr, int x, int y) {
		int count = 0;
		if((x + y) % 2 == 1) {
			for(int i = y; i >= y - 7; i--) {
				for(int j = x ; j >= x - 7; j--) {
					if((j + i) % 2 == 0 && arr[i].charAt(j) == arr[y].charAt(x)) count++; 
					else if((j + i) % 2 == 1 && arr[i].charAt(j) != arr[y].charAt(x)) count++;
				}
			}
		}
		else {
			for(int i = y; i >= y - 7; i--) {
				for(int j = x ; j >= x - 7; j--) {
					if((j + i) % 2 == 0 && arr[i].charAt(j) != arr[y].charAt(x)) count++; 
					else if((j + i) % 2 == 1 && arr[i].charAt(j) == arr[y].charAt(x)) count++;
				}
			}
		}
		return count;
	}
}
