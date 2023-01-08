package Recursion;

import java.util.Scanner;

public class hanoi_tower {
	static int[][] start;
	static int[][] end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		start = new int[num][];
		end = new int[num][];
		System.out.println((int)Math.pow(num,2) - 1);
		StringBuilder sb = new StringBuilder();
		lethanoi(num, sb);
		System.out.println(sb);
	}

	private static void lethanoi(int num, StringBuilder sb) {
		if(num == 1) {
			sb.append(1);
			sb.append(" ");
			sb.append(3);
			sb.append("\n");
			return ;
		}
		else if(num % 2 == 0) {
			lethanoi(num - 1, sb);
			int a = 1 ,b = 2;
			for(int i = 0; i <= sb.length(); i += 4) {
				if(a > 3) a = 1;
				if(b > 3) b = 1;
				sb.insert(i,a); i += 1;
				sb.insert(i," "); i += 1;
				sb.insert(i,b); i += 1;
				sb.insert(i,"\n"); i += 1;
				a++; b++;
			}
			return ;
		}
		else {
			lethanoi(num - 1, sb);
			int a = 1 ,b = 3;
			for(int i = 0; i <= sb.length(); i += 4) {
				if(a < 1) a = 3;
				if(b < 1) b = 3;
				sb.insert(i,a); i += 1;
				sb.insert(i," "); i += 1;
				sb.insert(i,b); i += 1;
				sb.insert(i,"\n"); i += 1;
				a--; b--;
			}
			return ;
		}
	}
}
