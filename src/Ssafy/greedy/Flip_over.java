package Ssafy.greedy;

import java.util.Scanner;

public class Flip_over {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int count = 0;
		char temp = str.charAt(0);
		for(int i = 1 ; i < str.length(); i++) {	
			if(str.charAt(i-1) == temp && str.charAt(i) != temp) count++;
		}
		
		System.out.println(count);
	}

}
