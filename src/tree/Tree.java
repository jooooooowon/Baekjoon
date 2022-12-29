package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tree {
	static long[] arr;
	static long n;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = range(num);
		//arr = new long[n+1];
		Arrays.fill(arr, -1);
		count = -1;
		for(int i = 0 ; i < num ; i++) {
			count++;
			int temp = Integer.parseInt(st.nextToken());
			if(temp == -1) arr[1] = 0;
			else {
				for(int j = 0 ; j <= n; j++) {
					if(arr[j] == temp) {
						if(arr[j*2] != -1) arr[j*2+1] = count;
						else arr[j*2] = count;
						break;
					}
				}
			}
			
		}
		count = 0;
		int cut = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <= n ; i++) {
			if(arr[i] == cut) {
				arr[i] = -1;
				break;
			}
		}
		find(1);
		System.out.println(count);
	}

	private static void find(int i) {
		if(arr[i] == -1) return;
		else if(i*2 >= n+1 || i*2+1 >= n+1) count++;
		else {
			if(arr[i*2] == -1 && arr[i*2+1] == -1) {
				count++;
				return ;
			}
			find(i*2);
			find(i*2+1);
		}
		
	}

	private static int range(int num) {
		if(num == 1) return 1;
		return 2*range(num-1)+1;
	}

}
