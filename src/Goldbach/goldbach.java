package Goldbach;

import java.util.Scanner;

public class goldbach {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();										//�׽�Ʈ ���̽� ����
		int[] num = new int[n];
		for(int i = 0; i < n ; i++) {
			num[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			letchk(num[i]);
		}
	}

	private static void letchk(int n) {
		int[] arr = new int[1230];
		arr[0] = 2;										// 2�� ù��° �Ҽ����� �˰� �������� �����س���
		int i = 1;
		for(int j = 3 ; j <= n ; j++) {					// n������ �Ҽ��� ã�� �迭�� �����ϱ�	
			int k;
			for(k = 0 ; arr[k] * arr[k] <= j; k++) {
				if(arr[k] == 0) break;
				else if(j % arr[k] == 0) break;
			}
			if(j % arr[k] != 0) {						
				arr[i] = j;
				i++;
			}
		}
		i = 0;
		int chk = 10000;
		int a = 0,b = 0;
		while (arr[i] != 0) {
			int j = i;
			while (arr[j] != 0) {
				if(arr[i] + arr[j] == n) {				// �Ҽ��� ����� �迭���� �� ���� ¦�� n�� ��� ã��
					if(chk > arr[j] - arr[i]) {			// ã�� �Ҽ��� �� ���̰� ���� ���� �� �Ҽ� ã��
						chk = arr[j] - arr[i];
						a = arr[i]; b = arr[j];			// ã�� �� �Ҽ� a,b�� ������ ����
					}		
				}
				j++;
			}
			i++;
		}
		System.out.printf("%d%s%d",a," ",b);
		System.out.println();
	}

}
