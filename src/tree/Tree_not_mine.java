package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_not_mine {
	static int[] arr;
	static boolean[] chk;
	static int n;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		chk = new boolean[n];
		int root = 0;
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == -1) root = i;
		}
		int cut = Integer.parseInt(br.readLine());
		delete(cut);
		find(root);
		System.out.println(count);
	}

	private static void find(int root) {
		chk[root] = true;
		boolean temp = true;
		if(arr[root] != -2) {
			for(int i = 0 ; i < n ; i++) {
				if(arr[i] == root && !chk[i]) {
					find(i);
					temp = false;
				}
			}
			if(temp) count++;
		}
	}

	private static void delete(int cut) {
		arr[cut] = -2;
		for(int i = 0 ; i < n ; i++) {
			if(arr[i] == cut) delete(i);
		}
	}

}
