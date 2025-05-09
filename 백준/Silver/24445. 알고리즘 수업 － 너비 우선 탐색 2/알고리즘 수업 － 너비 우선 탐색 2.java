import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] visited;

	static void bfs(int r) {
		int visit = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(r);
		visited[r] = visit++;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			Collections.sort(graph[curr], Collections.reverseOrder());
//			혹은 Comparator를 구현하여 사용 :
//				new Comparator<Integer>() {
//
//					@Override
//					public int compare(Integer o1, Integer o2) {
//						// TODO Auto-generated method stub
//						return 0;
//				}}
			for(int next : graph[curr]) {
				if(visited[next] != 0) {
					continue;
				}
				
				visited[next] = visit++;
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

		graph = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
			visited[i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[to].add(from);
			graph[from].add(to);
		}

		bfs(R);
		for (int i = 1; i <= N; i++) {
			bw.write(visited[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}