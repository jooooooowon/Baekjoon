package geometry;

import java.util.Scanner;

public class taxi_geometry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		System.out.printf("%.6f\n",Math.PI * Math.pow(r, 2));
		System.out.printf("%.6f",Math.pow(r,2) * 2);
	}

}
