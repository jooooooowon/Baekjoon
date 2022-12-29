package Ω∫≈√2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_explosion {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String explosion = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if(sb.length() >= explosion.length()) {
				boolean tf = true;
				for(int j = 0 ; j < explosion.length() ; j++) {
					if(sb.charAt(sb.length()-explosion.length()+j) != explosion.charAt(j)) {
						tf = false;
						break ;
					}
				}
				if(tf) sb.delete(sb.length()-explosion.length(), sb.length());
			}
		}
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
		
	}

}
