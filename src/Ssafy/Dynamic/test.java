package Ssafy.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	/**
	 * ���� 15486 ���2 (https://www.acmicpc.net/problem/15486)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] t = new int[n];
		int[] p = new int[n];
		
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp : N�Ͽ� ���� �� �ִ� �ִ� ����
		int[] dp = new int[n+1];
		
		//��ȭ��
		//���� ��¥���� �ҿ� �ð��� ����� ���� dp�� �����Ѵ�.
		//����, �ߺ��� �� �ִ밪�� �ִ´�.
		//dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
		
		for (int i=0; i<n; i++) {
			if (i + t[i] <= n) {
				//��¥�� ������ �Ѿ�� �ʴ� ���
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			//���� ����� ���� 0�� �� �ֱ� ������ ������ �ִ밪�� �־���.
			//�ش� ��¥�� ���� �� ���ٸ�, �������� ���� �ִ� ������ �־��־�� �Ѵ�.
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
		
	}//main
}//Resign2