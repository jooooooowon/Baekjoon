package num_of_word;

import java.util.Scanner;
import java.util.StringTokenizer;

public class numofword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		StringTokenizer stk = new StringTokenizer(str, " ");
		System.out.println(stk.countTokens());
	}

}
