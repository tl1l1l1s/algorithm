import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static int solution(int r) {
		int cnt = 1;
		
		visited[r] = true;
		for(int next : graph[r]) {
			if(visited[next]) continue;
			
			cnt = Math.max(cnt, 1 + solution(next));
		}
		visited[r] = false;
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 가중치 X 무방향그래프에서의 최장경로 
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			visited = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for(int j=1; j<=N; j++) {
				visited[j] = false;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[to].add(from);
				graph[from].add(to);
			}
			
			for(int i=1; i<=N; i++)  {
				for(int j=1; j<=N; j++) {
					visited[j] = false;
				}
				
				result = Math.max(solution(i), result);
			}
			
	// BFS로 풀었는데 오답 처리	
//	static int solution(int r) {
//		int cnt = 1; // 현재 값부터 카운트 = 1 시작
//		
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(r);
//		visited[r] = true;
//		
//		while(!q.isEmpty()) {
//			int curr = q.poll();
//			
//			for(int next : graph[curr]) {
//				if(visited[next]) continue;
//				
//				cnt++; // 다음 거리 추가
//				visited[next] = true;
//				q.add(next);
//			}
//		}
//		
//		return cnt;
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//
//		// 가중치 X 무방향그래프에서의 최장경로 
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int tc=1; tc<=T; tc++) {
//			st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			
//			graph = new ArrayList[N+1];
//			visited = new boolean[N+1];
//			result = 0;
//			for(int i=1; i<=N; i++) {
//				graph[i] = new ArrayList<Integer>();
//			}
//			for(int j=1; j<=N; j++) {
//				visited[j] = false;
//			}
//			
//			for(int i=0; i<M; i++) {
//				st = new StringTokenizer(br.readLine());
//				int from = Integer.parseInt(st.nextToken());
//				int to = Integer.parseInt(st.nextToken());
//				
//				graph[to].add(from);
//				graph[from].add(to);
//			}
//			
//			for(int i=1; i<=N; i++)  {
//				for(int j=1; j<=N; j++) {
//					visited[j] = false;
//				}
//				
//				result = Math.max(solution(i), result);
//			}
			
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}