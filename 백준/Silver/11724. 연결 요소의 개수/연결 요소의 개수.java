import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static Boolean[][] graph;
	static Boolean[] visited;
	
	static void dfs(int s) {
		
		for(int i=1; i<=N; i++) {
			if(graph[s][i]) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i);
				} else continue;
			} else continue;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 방향 없는 그래프가 주어졌을 때 연결요소의 개수를 구하는 프로그램 
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new Boolean[N+1][N+1];
		visited = new Boolean[N+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(graph[i], false);
			visited[i] = false;
		}
		
		for(int i=0; i<M; i++) {
			// u, v
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = true;
			graph[v][u] = true;
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
				result++;
			}
		}

		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}