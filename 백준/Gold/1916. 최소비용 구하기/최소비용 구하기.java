import java.io.*;
import java.util.*;

public class Main {
	final static int INF = Integer.MAX_VALUE;
	static List<Node>[] graph;
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			graph[Integer.parseInt(st.nextToken())].add(
					new Node(Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken())));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 최단 거리 기록용 배열 초기화
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0; // 시작 노드의 거리는 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			// 노드에 저장되어있던 거리와 큐에 있는 거리를 비교하여 중복 계산을 방지
			if(current.cost > dist[current.to]) continue;
			
			// 인접 노드 탐색
			for(Node next : graph[current.to]) {
				// 기존 경로보다 새 경로가 더 짧은 경우 갱신하고 큐에 추가
				if(dist[next.to] > current.cost + next.cost) {
					dist[next.to] = current.cost + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		bw.write(dist[end] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}