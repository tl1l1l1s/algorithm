import java.io.*;
import java.util.*;

public class Main {
	static int current = 1;
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] visited;
	
	static void dfs(int R) {
		visited[R] = current++;
		
		Collections.sort(graph[R], new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		for(int next : graph[R]) {
			if(visited[next] != 0) {
				continue;
			}
			
			dfs(next);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
			visited[i] = 0;
		}
		
		for(int i=0; i<M; i++) {
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