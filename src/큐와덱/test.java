package ť�͵�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
 
public class test {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
 
		
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		while(T --> 0) {
			
			String command = br.readLine();	// �������� p�� �ش��ϴ� ��ɾ�
			int n = Integer.parseInt(br.readLine());
			
			/*
			 *  [a,b,c,...,x] �� �����ؾ� �� ���� ���ȣ([, ])�� ����(,) �̴�.
			 *  StringTokenizer�� ���� �����ڸ� ��� �ϰ� �ʹٸ�
			 *  ������ ���ڵ��� ���ļ� �Ѱ��ָ� �ȴ�.
			 *  
			 *  ���� split()�� ����ϰ���� ��� ���Խ����δ�
			 *  String input = br.readLine();
			 *  String[] s = input.subString(1, input.length - 1).split(","); �� ���־�� �Ѵ�.
			 *  
			 *  subString�� �����ʰ�, split("[^0-9]") �Ǵ�, 
			 *  split("[\\[\\]\\,") ���� ���Խ����θ� ���ٸ� ù ��° ���ڰ� ���ԽĿ� �ɷ�
			 *  �� ���ڿ��� ��ȯ�ϰ� �Ǳ� ����
			 *  
			 *  ex)
			 *  str = "[1,2,3,4]";
			 *  strr[] = str.split("[\\[\\]\\,");
			 *  
			 *  result)
			 *  strr[0] = ""
			 *  strr[1] = "1"
			 *  strr[2] = "2"
			 *  strr[3] = "3"
			 *  strr[4] = "4"
			 */
			st = new StringTokenizer(br.readLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			// ���� �迭 ���Ҹ� �־��ش�.
			for(int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deque);
		}
		
		System.out.println(sb);
		
	}
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		
		boolean isRight = true;
		
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;	// ������ �ٲ��ش�.
				continue;
			}
			
			
			// �Ʒ��� D�� ���
			
			// D �Լ��̸鼭 isRight�� true �� ���
			if(isRight) {
				
				// ���� ��ȯ �� ���Ұ� ���� ��� error�� ����ϵ��� �ϰ� �Լ� ����
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
				
			}
			else {
				// ���� ��ȯ �� ���Ұ� ���� ��� error�� ����ϵ��� �ϰ� �Լ� ����
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		
		// ��� �Լ����� ���������� �۵��ߴٸ� ���� ���� ��ҵ��� ��¹����� ������ش�.
		makePrintString(deque, isRight);
		
	}
	
	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		
		sb.append('[');	// ���� ���ȣ ���� StringBuilder�� ����
		
		if(deque.size() > 0) {	//���� ��� �� ���Ұ� �� �� �̻��� ���
			
			if(isRight) {	// �������ϰ�� 
				
				sb.append(deque.pollFirst());	// ���� ù ��° ���Ҹ� �Ѱ��ش�.
				
				// �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ϳ��� �̾� �ѱ��. 
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {	// �������ϰ�� 
				sb.append(deque.pollLast());	// ���� �ڿ������� ù ��° ���Ҹ� �Ѱ��ش�.
				
				// �� ���� ���Һ��� ������ ���� �Ѱ��� �� ���� ���Ҹ� �ڿ������� �ϳ��� �̾� �ѱ��. 
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');	// �ݴ� ���ȣ �� �������� ������
	}
}