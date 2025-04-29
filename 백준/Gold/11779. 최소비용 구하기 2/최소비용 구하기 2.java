import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static ArrayList<Bus>[] buses;
	static int[] cost;
	static ArrayList<Integer>[] route;
	
	static class Bus implements Comparable<Bus>{
		int to;
		int cost;
		
		Bus(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return this.cost - o.cost;
		}
	}
	
	static void solution(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		cost[start] = 0;
		pq.offer(new Bus(start, 0));
		
		while(!pq.isEmpty()) {
			Bus current = pq.poll();
			
			if(current.cost > cost[current.to]) continue;
			
			for(Bus next : buses[current.to]) {
				if(cost[current.to] + next.cost < cost[next.to]) {
					route[next.to] = new ArrayList<>(route[current.to]);
					route[next.to].add(current.to);
					
					cost[next.to] = cost[current.to] + next.cost;
					pq.add(new Bus(next.to, cost[next.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// n개의 도시
		// 다른 도시에 도착하는 m개의 버스
		// a -> b로 가는 버스 비용 최소화
		// 시작점에서 도착점으로의 경로가 항상 존재 
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N+1];
		route = new ArrayList[N+1];
		buses = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			route[i] = new ArrayList<>();
			cost[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<=N; i++) {
			buses[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			buses[from].add(new Bus(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		solution(a);
		
		bw.write(cost[b] + "\n");
		bw.write((route[b].size()+1) + "\n");
		for(int x : route[b]) {
			bw.write(x + " ");
		}
		bw.write(b + "");
		bw.flush();
		bw.close();
		br.close();

	}

}