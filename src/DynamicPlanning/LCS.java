package DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_i = br.readLine();
		String str_j = br.readLine();
		int[][] arr = new int[str_j.length() + 1][str_i.length() + 1];
		for(int i = 0; i < str_i.length(); i++) {
			arr[0][i] = 0;
		}
		for(int j = 0; j < str_j.length(); j++) {
			arr[j][0] = 0;
		}
		for(int j = 1; j <= str_j.length(); j++) {
			for(int i = 1 ; i <= str_i.length(); i++) {
				if(str_j.charAt(j - 1) == str_i.charAt(i - 1)) {
					arr[j][i] = arr[j-1][i-1] + 1;
				}
				else {
					arr[j][i] = Math.max(arr[j-1][i],arr[j][i-1]);
				}
			}
		}
		System.out.println(arr[str_j.length()][str_i.length()]);
	}

}
