import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int N;
	static int V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static void bfs() throws IOException {
		initialize();
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(V);
		visited[V] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			bw.write(curr + " ");
			Collections.sort(graph[curr]);
			for(int next : graph[curr]) {
				if(visited[next]) continue;
				
				visited[next] = true;
				q.add(next);
			}
		}
	}
	
	static void dfs(int v) throws IOException {
		// v로 시작, 한 놈을 팬다
		if(visited[v]) return;
		
		bw.write(v + " ");
		visited[v] = true;
		Collections.sort(graph[v]);
		for(int next : graph[v]) {
			if(visited[next]) continue;
			
			dfs(next);
		}
		
	}
	
	static void initialize() {
		for(int i=1; i<=N; i++) {
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// DFS와 BFS로 탐색한 결과를 출력
		// 정점 번호가 작은 것을 먼저 방문, 방문할 수 있는 것이 없는 경우 종료		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		initialize();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			graph[to].add(from);
			graph[from].add(to);
		}

		initialize();
		dfs(V);
		bw.write("\n");
		
		bfs();
		bw.write("\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}