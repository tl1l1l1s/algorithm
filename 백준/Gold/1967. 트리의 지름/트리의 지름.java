import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] dist;
	
	static void dfs(int idx) {
		
		for(int n=0; n<tree[idx].size(); n+=2) {
			int nxt = tree[idx].get(n);
			int d = tree[idx].get(n+1);
			
			if(dist[nxt] != -1) continue;
			
			dist[nxt] = dist[idx] + d;
			dfs(nxt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 무방향 그래프
		// 두 노드를 선택해 양쪽으로 당겼때 가장 길게 늘어나는 경우
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int n=1; n<=N; n++) {
			tree[n] = new ArrayList<>();
		}
		
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree[parent].add(child);
			tree[parent].add(weight);
			
			tree[child].add(parent);
			tree[child].add(weight);
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		dist[1] = 0;
		dfs(1);
		int res = 1, temp = 0;
		for(int d=1; d<=N; d++) {
			if(temp < dist[d]) {
				temp = dist[d];
				res = d;
			}
		}
		
		Arrays.fill(dist, -1);
		dist[res] = 0;
		dfs(res);
		int result = 0;
		for(int d=1; d<=N; d++) {
			if(result < dist[d]) {
				result = dist[d];
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}