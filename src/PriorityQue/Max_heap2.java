package PriorityQue;

import java.util.ArrayList;
import java.util.Scanner;

public class Max_heap2 {
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		list.add(0);
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(list.size() == 1) sb.append(0 + "\n");
				else {
					sb.append(list.get(1) + "\n");
					list.set(1,list.get(list.size() - 1));
					list.remove(list.size() - 1);
					reput();
				}
			}
			else {
				put(x);
			}
		}
		System.out.println(sb);
	}

	private static void reput() {
		int index = 1;
		while(index * 2 + 1 < list.size()) {
			if(list.get(index) < Math.max(list.get(index * 2), list.get(index * 2 + 1))){
				int temp_i = list.indexOf(Math.max(list.get(index * 2),list.get(index * 2 + 1)));
				int temp = list.get(temp_i);
				list.set(temp_i,list.get(index));
				list.set(index, temp);
			}
			else break;
		}
	}

	private static void put(int x) {
		list.add(x);
		int size = list.size() - 1;
		while(size/2 > 0) {
			if(list.get(size) > list.get(size/2)) {
				int temp = list.get(size/2);
				list.set(size/2 , list.get(size));
				list.set(size, temp);
				size = size/2;
			}
			else break;
		}
	}
}

