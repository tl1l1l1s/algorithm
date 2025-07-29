import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int v; 
		int e;
		
		Node(int v, int e) {
			this.v = v;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.e, o.e);
		}
	}
	
	static int V;
	static ArrayList<Node>[] graph;
	static int[] distance;
	
	private static void dijkstra(int k) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		boolean[] check = new boolean[V+1];
		queue.add(new Node(k, 0));
		distance[k] = 0;
		
		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			int curr = currNode.v;
			
			if(check[curr]) continue;
			check[curr] = true;
			
			for(Node node : graph[curr]) {
				if(distance[node.v] > distance[curr] + node.e) {
					distance[node.v] = distance[curr] + node.e;
					queue.add(new Node(node.v, distance[node.v]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 방향 그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하라

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		distance = new int[V+1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int tc=0; tc<E; tc++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, e));
		}
		
		dijkstra(K);
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(distance[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}