import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] affected;
	
	static void solution() {
		Queue<Integer> q = new LinkedList<>();
		affected[1] = true;
		q.add(1);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : graph[curr]) {
				if(affected[next]) continue;
				
				affected[next] = true;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 웜 바이러스에 걸린 컴퓨터
		// 네트워크 상에서 연결되어 있지 않다면 영향 받지 않음 -> X
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		affected = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
			affected[i] = false;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[to].add(from);
			graph[from].add(to);
		}

		solution();
		int result = 0;
		for(int i=2; i<=N; i++) {
			if(affected[i]) result++;
		}
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}