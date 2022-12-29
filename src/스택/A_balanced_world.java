package Ω∫≈√;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class A_balanced_world {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			if(str.equals(".")) break;
			boolean tf = true;
			for(int i = 0 ; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.push(str.charAt(i));
					tf = false;
				}
				else if(str.charAt(i) == ')') {
					if(stack.size() > 0 && stack.peek() == '(') {
						tf = true;
						stack.pop();
					}
					else {
						tf = false;
						break;
					}
				}
				else if(str.charAt(i) == '[') {
					stack.push(str.charAt(i));
					tf = false;
				}
				else if(str.charAt(i) == ']') {
					if(stack.size() > 0 && stack.peek() == '[') {
						tf = true;
						stack.pop();
					}
					else {
						tf = false;
						break;
					}
				}
			}
			if(tf && stack.size() == 0) System.out.println("yes");
			else System.out.println("no");
		}
	}

}
