import java.io.*;
import java.util.*;

public class Main {
	static int N, E, V1, V2;
	static List<Route>[] graph;
	static boolean[] visited;
	
	static class Route implements Comparable<Route>{
		int to;
		int cost;
		
		Route(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Route o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] solution(int start) {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		Arrays.fill(visited, false);
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		pq.add(new Route(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Route current = pq.poll();
			int to = current.to;
			
			if(visited[to]) {
				continue;
			}
			
			visited[to] = true;
			for(Route next : graph[to]) {
				if(dp[to] + next.cost < dp[next.to]) {
					dp[next.to] = dp[to] + next.cost;
					pq.add(new Route(next.to, dp[next.to]));
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Route>();
		}

		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Route(to, cost));
			graph[to].add(new Route(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
		int[] from1 = solution(1);
		int[] fromV1 = solution(V1);
		int[] fromV2 = solution(V2);
		
		long path1 = -1, path2 = -1;
		if(from1[V1] != Integer.MAX_VALUE 
			&& fromV1[V2] != Integer.MAX_VALUE
			&& fromV2[N] != Integer.MAX_VALUE) {
			path1 = from1[V1] + fromV1[V2] + fromV2[N];
		}
		
		if(from1[V2] != Integer.MAX_VALUE 
			&& fromV2[V1] != Integer.MAX_VALUE
			&& fromV1[N] != Integer.MAX_VALUE) {
			path2 = from1[V2] + fromV2[V1] + fromV1[N];
		}
		
		bw.write(Math.min(path1, path2) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}