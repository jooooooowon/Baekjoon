package maybeoveravg;

import java.util.Scanner;

public class maybe_over_avg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase; 
		
		int countcase = sc.nextInt(); 									//케이스 개수
		double[] rat = new double[countcase];
		
		for(int j = 0 ; j < countcase; j++) {
			testcase = sc.nextInt();									//점수 개수
			int[] score = new int[testcase];
			for(int i = 0 ; i < testcase; i++) {
				score[i] = sc.nextInt();
			}
			rat[j] = letavg(score);
		}
		
		for(int i = 0; i < countcase; i++) {
			System.out.printf("%.3f%s\n",rat[i],"%");
		}
	}

	private static double letavg(int[] score) {
		int result = 0;
		for(int i = 0 ; i < score.length; i++) {
			result += score[i];
		}
		result = result / score.length;
		double count = 0;
		for(int i = 0 ; i < score.length; i++) {
			if(score[i] > result) count++;
		}
		return 100 * count / score.length;
	}

}
