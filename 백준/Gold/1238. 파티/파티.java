import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int X;
	static List<Town>[] go; // 갈 때의 도로 거리를 저장
	static List<Town>[] come; // 귀가 할 때의 도로 거리를 저장
	
	static class Town implements Comparable<Town> {
		int to;
		int cost;
		
		public Town(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Town o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] dijkstra(List<Town>[] list, int start) {
		Queue<Town> q = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		q.add(new Town(start, 0));
		dp[start] = 0;
		
		while(!q.isEmpty()) {
			Town curr = q.poll();
			
			int to = curr.to;
			
			if(check[to]) {
				continue;
			}
			check[to] = true; // 방문 여부
			
			for(Town next : list[to]) {
				// 현 도착지까지 + 다음 도착지 < dp[다음 도착지]면 갱신 및 큐에 추가 
				if(dp[to] + next.cost < dp[next.to]) {
					dp[next.to] = dp[to] + next.cost;
					q.add(new Town(next.to, dp[next.to]));
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
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		go = new ArrayList[N+1];
		come = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			go[i] = new ArrayList<>();
			come[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			go[from].add(new Town(to, cost));
			come[to].add(new Town(from, cost));
		}

		int[] goDp = dijkstra(go, X);
		int[] comeDp = dijkstra(come, X);
		int result = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			result = Math.max(result, goDp[i] + comeDp[i]);
		}
		 bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}