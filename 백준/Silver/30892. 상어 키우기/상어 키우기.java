import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 상어의 머릿수
		int K = Integer.parseInt(st.nextToken()); // 먹을 수 있는 상어 마릿수
		int T = Integer.parseInt(st.nextToken()); // 초기 상어 사이즈

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> bigger = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(s < T) {
				smaller.add(s);
			} else bigger.add(s);
		}
		
		long t = T;
		while(K > 0 && smaller.size() > 0) {
			t += smaller.poll();
			
			while(bigger.size() > 0 && bigger.peek() < t) {
				smaller.add(bigger.poll());
			}
			K--;
		}
		
		bw.write(t + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}