package DynamicPlanning;

import java.util.Scanner;

public class Easy_number_of_steps {
	static Integer[][] temp;
	static int mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		temp = new Integer[n + 1][10];
		temp[1][0] = 0;
		for(int i = 1 ; i < 10; i++) {
			temp[1][i] = 1;
		}
		for(int i = 0 ; i < 10; i++) {
			easy_num_of_steps(n,i);
		}
		int result = 0;
		for(int i = 0 ; i < 10 ; i++) {
			result += temp[n][i];
			result %= mod;
		}
		System.out.println(result);
		
	}

	private static int easy_num_of_steps(int j, int i) {
		if(temp[j][i] == null) {
			if(i == 0) {
				temp[j][i] = easy_num_of_steps(j - 1, i + 1) % mod;
			}
			else if(i == 9) {
				temp[j][i] = easy_num_of_steps(j - 1, i - 1) % mod;
			}
			else {
				temp[j][i] = (easy_num_of_steps(j - 1, i + 1) + easy_num_of_steps(j - 1, i - 1)) % mod;
			}
		}
		
		return temp[j][i] % mod;
	}

}
