package Á¤·Ä;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sort_inside {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int len = (int)Math.log10(num) + 1;
		int[] arr = new int[len];
		for(int i = 0 ; i < len ; i++) {
			arr[i] = num % 10;
			num /= 10;
		}
		Arrays.sort(arr);
		Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Comparator.reverseOrder());
		for(int i = 0 ; i < len; i++) {
			System.out.print(tmp[i]);
		}
	}

}
