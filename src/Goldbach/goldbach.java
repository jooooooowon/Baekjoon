package Goldbach;

import java.util.Scanner;

public class goldbach {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();										//테스트 케이스 갯수
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
		arr[0] = 2;										// 2는 첫번째 소수임을 알고 있음으로 저장해놓기
		int i = 1;
		for(int j = 3 ; j <= n ; j++) {					// n까지의 소수를 찾고 배열에 저장하기	
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
				if(arr[i] + arr[j] == n) {				// 소수가 저장된 배열에서 두 합이 짝수 n인 경우 찾기
					if(chk > arr[j] - arr[i]) {			// 찾은 소수들 중 차이가 가장 작은 두 소수 찾기
						chk = arr[j] - arr[i];
						a = arr[i]; b = arr[j];			// 찾은 두 소수 a,b에 저장해 놓기
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
