package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lost_parenthesis{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] temp_minus = str.split("-");
		int[] arr = new int[temp_minus.length];
		for(int i = 0 ; i < temp_minus.length; i++) {
			String[] temp_plus = temp_minus[i].split("\\+");
			int sum = 0;
			for(int j = 0 ; j < temp_plus.length; j++) {
				sum += Integer.parseInt(temp_plus[j]);
			}
			arr[i] = sum;
		}
		int result = arr[0];
		for(int i = 1; i < arr.length; i++) {
			result -= arr[i];
		}
		
		System.out.println(result);
		
	}

}
