import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] cities;
	static int[] dist;
	
	static void dfs(int idx) {
		
		for(int nxt : cities[idx]) {
			if(dist[nxt] != -1) continue;
			
			dist[nxt] = dist[idx] + 1;
			dfs(nxt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 천나라 N개 도시, 양방향 도로
		// N-1개의 도로 이용, 모든 도시 사이 경로 거리 1짜리 단 한 개만 존재
		
		// 소방차가 출동해 다른 도시에 도착을 할 때 이동해야 하는 거리 중 최대가 최소가 되는 지점
		// 다른 도시에 도착해야 할 때 이동해야 하는 거리 중 최대 거리
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cities = new ArrayList[N+1];
		
		for(int n=1; n<=N; n++) {
			cities[n] = new ArrayList<Integer>();
		}
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cities[a].add(b);
			cities[b].add(a);
		}
		
		/**
		 * 1. 제일 긴 트리의 지름을 구한다
		 * 2. 제일 긴 트리의 지름의 1/2 지점에 소방서를 두는 것이 최적의 답
		 * 3. 제일 먼 길이도 제일 긴 트리의 지름의 1/2에 해당
		 */
		
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		dist[1] = 0;
		dfs(1);
		
		int temp = 0, res = 0;
		for(int d=1; d<=N; d++) {
			if(temp < dist[d]) {
				res = d;
				temp = dist[d];
			}
		}
		
		Arrays.fill(dist, -1);
		dist[res] = 0;
		dfs(res);
		temp = 0;
		for(int d=1; d<=N; d++) {
			if(temp < dist[d]) {
				temp = dist[d];
			}
		}
		
		bw.write(((temp+1)/2) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}