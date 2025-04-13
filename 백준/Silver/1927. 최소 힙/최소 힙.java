import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(minHeap.size() == 0) {
					bw.write("0\n");
				} else {
					bw.write(minHeap.poll()+"\n");
				}
			} else {
				minHeap.add(x);
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}