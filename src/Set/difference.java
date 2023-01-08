package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class difference {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer> nhs = new HashSet<>();
		HashSet<Integer> mhs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			nhs.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m; i++) {
			mhs.add(Integer.parseInt(st.nextToken()));
		}
		HashSet<Integer> result1 = new HashSet<>(nhs);
		HashSet<Integer> result2 = new HashSet<>(mhs);
		result1.removeAll(mhs);
		result2.removeAll(nhs);
		int result = result1.size() +result2.size();
		System.out.println(result);
	}

}
