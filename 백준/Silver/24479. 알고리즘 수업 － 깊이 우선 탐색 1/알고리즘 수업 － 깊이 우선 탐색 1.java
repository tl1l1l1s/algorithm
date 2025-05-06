import java.io.*;
import java.util.*;

public class Main {
    static int curr = 1;
	static ArrayList<Integer>[] graph;
	static int visited[];
	static BufferedWriter bw;
	
	static void dfs(int s) throws IOException {
		visited[s] = curr;
		curr += 1;
		Collections.sort(graph[s]);
		
		for(int next : graph[s]) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N개의 정점, M개의 간선 무방향 그래프
		// 정점은 1~N, 가중치는 1
		// 오름차순으로 방문, 노드의 방문 순서 출력
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
			visited[i] = 0;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[to].add(from);
			graph[from].add(to);
		}
		
		dfs(R);
		for(int i=1; i<=N; i++) {
			bw.write(visited[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}