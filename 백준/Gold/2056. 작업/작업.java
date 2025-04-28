import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] cost;
	static int[] time; // 작업에 걸리는 시간
	static int[] indegree; // 선행 작업 개수
	static ArrayList<Integer>[] list; // 선행 작업 목록

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 수행해야 할 작업 N개
		// 걸리는 시간은 정수 
		// 먼저 완료 해야하는 작업이 존재하면 K번 작업의 선행관계 작업은 1~K-1 사이의 값 
		// 선행 관계 없으면 동시수행 o => 선행 관계 없는 작업들 중 Math.max 실행 시간을 구해서 더한 뒤 실행
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		cost = new int[N+1];
		time = new int[N+1];
		indegree = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			list[i] = new ArrayList<>();
			time[i] = Integer.parseInt(st.nextToken());
			indegree[i] = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<indegree[i]; j++) {
				list[Integer.parseInt(st.nextToken())].add(i);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				cost[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
						
			for(int next : list[current]) {
				cost[next] = Math.max(cost[current] + time[next], cost[next]);
				indegree[next]--;
					
				if(indegree[next] == 0) {
					q.offer(next);
			 	}
			}
		}
		

		int result = 0;
		for(int i=1; i<=N; i++) {
			result = Math.max(cost[i], result);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}