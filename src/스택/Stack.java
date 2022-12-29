package Ω∫≈√;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
			else if(str.equals("pop")) {
				if(list.isEmpty()) System.out.println(-1);
				else {
					System.out.println(list.get(list.size() - 1));
					list.remove(list.size() - 1);
				}
			}
			else if(str.equals("size")) {
				System.out.println(list.size());
			}
			else if(str.equals("empty")) {
				if(list.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(str.equals("top")) {
				if(list.isEmpty()) System.out.println(-1);
				else System.out.println(list.get(list.size() - 1));
			}
			
		}
	}

}
