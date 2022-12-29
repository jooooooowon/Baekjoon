package selfnum;

import java.util.Arrays;

public class selfnum {

	public static void main(String[] args) {
		int n;
		int[] arr = new int[10001];
		arr[0] = 0;
		for(n = 1; n <= 10000; n++) {
			arr[n] = newnum(n);
		}		
		Arrays.sort(arr);
		int i = 1;
		while(arr[i] <= 10000) {
			if(arr[i] != arr[i - 1] + 1 && arr[i] != arr[i - 1]) System.out.println(arr[i - 1] + 1);
			i++;
		}
		
		
		
	}

	private static int newnum(int n) {
		int result = 0;
		int temp = n;
		do {
			result = result + temp % 10;
			temp = temp / 10;
		}while(temp != 0);
		return result + n;
	}

}
