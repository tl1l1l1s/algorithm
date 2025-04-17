import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 위상정렬 = 선수 관계가 명확한 작업들의 순서를 정할 때 사용
		// 구현 : 큐, 진입차수를 활용하여 모든 노드의 진입 차수를 센다
				// 진입차수가 0인 노드를 큐에 넣는다
				// 노드를 꺼내 정렬 결에 추가하고, 그 노드에서 나가는 모든 간선들의 진입차수를 -1
				// 진입차수가 0이 된 노드를 큐에 넣는다
				// 큐가 빌 때까지 반복, 꺼낸 순서가 위상정렬의 순서
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N+1]; // 학생의 키 관계 등록
		int[] rank = new int[N+1]; // 진입 차수를 세는 배열
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) { // 초기화
			list[i] = new ArrayList<>();
			rank[i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			list[front].add(back);
			rank[back]++;
		}
		
		for(int i=1; i<N+1; i++) {
			if(rank[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			bw.write(curr + " ");
			for(int next : list[curr]) {
				rank[next]--;
				
				if(rank[next] == 0) {
					queue.add(next);
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}