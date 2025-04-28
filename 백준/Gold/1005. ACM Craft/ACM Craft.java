import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int[] cost;
	static int[] time;
	static int[] indegree;
	static ArrayList<Integer>[] list;
	
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				cost[i] = time[i];
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int next : list[current]) {
				indegree[next]--;
				
				if(indegree[next] == 0) {
					cost[next] = Math.max(cost[current] + time[next], cost[next]);
					q.offer(next);
				}
				cost[next] = Math.max(cost[current] + time[next], cost[next]);
			}
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			time = new int[N+1];
			cost = new int[N+1];
			indegree = new int[N+1];
			list = new ArrayList[N+1];
			
			for(int j=1; j<=N; j++) {
				indegree[j] = 0;
				cost[j] = 0;
				list[j] = new ArrayList<>();
				time[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int prior = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				list[prior].add(next);
				indegree[next]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			topologySort();
			bw.write(cost[W] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}