import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int x = 1;
	static int[] visited;
	
	public static void bfs(int r) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(r);
		visited[r] = x++;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			Collections.sort(graph[current]);
			for(int next : graph[current]) {
				if(visited[next] != 0) {
					continue;
				}
				
				visited[next] = x++;
				q.add(next);
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[to].add(from);
			graph[from].add(to);
		}
		bfs(R);
		
		for(int i=1; i<=N; i++) {
			bw.write(visited[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}