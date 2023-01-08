package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bracket {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i = 0 ; i < n ; i++) {
			Stack<Character> stack= new Stack<>();
			String str = br.readLine();
			boolean tf = false;
			for(int j = 0 ; j < str.length() ; j++) {
				char ch = str.charAt(j);
				if(ch == '(') {
					stack.push(ch);
				}
				else if(ch == ')') {
					if(stack.size() > 0 && stack.peek() == '(') {
						stack.pop();
						tf = true;
					}
					else {
						tf = false;
						break ;
					}
				}
			}
			if(tf && stack.size() == 0) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}

}
