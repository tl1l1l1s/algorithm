import java.io.*;
import java.util.*;

public class Main {
	
	static class Status {
		int x;
		int count;
		
		Status(int x, int c) {
			this.x = x;
			this.count = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동생은 점 0 <= K <= 100000
		// 수빈은 X에서 걸어 +1, -1 혹은 2*X
		// 빠른 시간이 몇초 후인지 && 몇 가지로찾을 수 잇는지 

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 경우가 세 가지 : X+1, X-1, 2*X
		// 스탑 케이스 : k*2보다 크면, 0 이하면
		
		int resultTime = Integer.MAX_VALUE;
		int resultCount = 0;
		int[] visited = new int[1000001];
		Arrays.fill(visited, -1);
		
		Queue<Status> q = new ArrayDeque<Status>();
		q.add(new Status(N, 0));
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			Status current = q.poll();
			
			if(current.count > resultTime) break;
			
			// K와 동일한 경우
			if(current.x == K) {
				if(resultTime > current.count) {
					resultTime = current.count;
					resultCount = 1;
				} else if(resultTime == current.count) {
					resultCount++;
				} 
				continue;
			}
			
			int[] next = {current.x - 1, current.x + 1, current.x * 2};
			// 범위를 넘은 경우 진행 X
			for(int n : next) {
				if(n > 100000 || n < 0) continue;
				
				if(visited[n] == -1) {
					visited[n] = current.count + 1;
					q.add(new Status(n, current.count + 1));	
				} else if(visited[n] == current.count + 1) {
					q.add(new Status(n, current.count + 1));
				}
			}
		}                                                                                              	
		
		bw.write(resultTime + "\n" + resultCount + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}