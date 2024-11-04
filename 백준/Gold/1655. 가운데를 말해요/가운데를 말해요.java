import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        // priority queue 사용하여 maxHeap과 minHeap 생성
        // 두 개의 priority queue를 통하여 중앙값을 구함
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int temp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(temp);
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.print(sb);

	}

}
