package Recursion;

import java.util.Scanner;

public class What_is_recursive_func {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		What_is_recursive_func1(num , 0);
	}

	private static String What_is_recursive_func1(int num, int i) {
		
		System.out.print("____".repeat(i)); System.out.println("\"����Լ��� ������?\"");
		if(num != i) {
			System.out.print("____".repeat(i)); System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.print("____".repeat(i)); System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.print("____".repeat(i)); System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			return What_is_recursive_func1(num, i + 1);
		}	
		else {
			System.out.print("____".repeat(i)); System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			return What_is_recursive_func2(num,i);
		}
	}

	private static String What_is_recursive_func2(int num, int i) {
		System.out.print("____".repeat(i)); System.out.println("��� �亯�Ͽ���.");
		if(i == 0) return null;
		else return What_is_recursive_func2(num , i - 1);
	}

}
