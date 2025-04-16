import java.io.*;
import java.util.*;

public class Main {
	final static long LNF = Long.MAX_VALUE;
	
	static class Node {
		int city; // 현재 도시의 번호
		long cost; // 누적 이동 시간(비용)
		int cnt; // 현재까지 포장한 도로의 개수
		
		public Node(int city, long cost, int cnt) {
			this.city = city;
			this.cost = cost;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시의 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 수
		int K = Integer.parseInt(st.nextToken()); // 포장할 도로의 수
		
		ArrayList<ArrayList<Node>> road = new ArrayList<>(); // 두 도시와 도로를 통과하는 데 걸리는 시간
		for(int i=0; i<N+1; i++) {
			road.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			road.get(from).add(new Node(to, cost, 0));
			road.get(to).add(new Node(from, cost, 0));
		}
		
		long[][] dist = new long[N+1][K+1]; // 도로 포장을 했을 때, 안 했을 때 구분을 위해 2차원 배열로 생성
		for(int i=0; i<=N; i++) {
			Arrays.fill(dist[i], LNF);
		}
		
		// start == 1
		dist[1][0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(
				Comparator.comparingLong(o -> o.cost));
		pq.offer(new Node(1, 0, 0));

		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			 
			if(current.cost > dist[current.city][current.cnt]) {
				continue;
			}
			
			for(Node next : road.get(current.city)) {
				
				// 도로 포장 O cnt 추가, cost 유
				if(current.cnt < K // current.cnt가 K보다 작으며
						&& dist[next.city][current.cnt+1] 
								> dist[current.city][current.cnt]) // dist[다음 도시][cnt+1] > dist[현재 도시][현재 cnt]
				{
					dist[next.city][current.cnt+1] = dist[current.city][current.cnt];
					pq.add(new Node(next.city, dist[next.city][current.cnt+1], current.cnt+1));
				}
				// 도로 포장 X cnt 유지, cost 추가
				if(dist[next.city][current.cnt] // 다음 도시의 현 cnt가
						> dist[current.city][current.cnt] + next.cost)  // 현 도시 dist + 다음 도시 cost보다 크면
				{
					dist[next.city][current.cnt] = dist[current.city][current.cnt] + next.cost;
					pq.add(new Node(next.city, dist[next.city][current.cnt], current.cnt));
				}
				
			}
		}
		
		bw.write(Arrays.stream(dist[N]).min().getAsLong()
				+ "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}