import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(maxHeap.size() != 0) {
					bw.write(maxHeap.poll() + "\n");
				} else {
					bw.write("0\n");
				}
			} else {
				maxHeap.add(x);
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}