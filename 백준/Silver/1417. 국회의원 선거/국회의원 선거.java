import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine()); // 다솜
		int result = 0;

		Queue<Integer> oc = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=1; i<N; i++) {
			oc.add(Integer.parseInt(br.readLine()));
		}
		
		while(!oc.isEmpty() && oc.peek() >= D) {
			int t = oc.poll();
			oc.add(t-1);
			result++;
			D++;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}