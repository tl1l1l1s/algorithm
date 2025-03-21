import java.io.*;
import java.util.*;

public class Main {
	// queue를 사용하여 풀이 
	static LinkedList<int[]> queue;
	
	static int printer(int M) {
		int printCount = 0;
		boolean isMax;
		
		// queue가 비지 않은 때만 반복
		while(!queue.isEmpty()) {
			isMax = true;
			// 제일 앞의 인쇄물 == curr
			int[] curr = queue.poll();
			
			for(int j = 0; j<queue.size(); j++) {
				
				// curr의 priority와 다른 값들의 priority 비교
				if(curr[1] < queue.get(j)[1]) {
					isMax = false;
					// 최댓값이 아닌 경우 j까지 전부 poll -> offer 진행
					queue.offer(curr);
					
					for(int k=0; k<j; k++) {
						queue.offer(queue.poll());
					}
					break;
				}
			}
			
			// isMax == true(curr이 최댓값이었던 경우)
			if(isMax) {
				printCount++;
				
				// curr의 index가 M과 동일한 경우 return 
				if(curr[0] == M) {
					return printCount;
				}
			}
		}
		return printCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<TC; i++) {
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				queue.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			bw.write(printer(M) + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
