import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int c; // city
		long dist; // distance
		
		Node(int c, long dist) {
			this.c = c;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도시
		int M = Integer.parseInt(st.nextToken()); // 도로
		int K = Integer.parseInt(st.nextToken()); // k번째 최단경로
		List<Node>[] routes = new ArrayList[N+1];
		int[] counts = new int[N+1]; // 몇 번째 방문인지 확인하기 위함
		long[] result = new long[N+1]; // 결과 저장용
		// 초기화
		Arrays.fill(counts, K);
		Arrays.fill(result, -1);
		for(int i=0; i<=N; i++) {
			routes[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			routes[Integer.parseInt(st.nextToken())].add(
					new Node(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		
        // 우선순위큐를 사용 -> 더 짧은 distance인 값부터 나옴
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
		q.add(new Node(1, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int currCity = curr.c;
			long currDist = curr.dist;
			
			counts[currCity]--;
			
            // count == 0인 경우 result 갱신
			if(counts[currCity] == 0) {
				result[currCity] = currDist;
			}
			
            // count가 0보다 작은 경우에는 갱신 필요 없음 -> -1 처리
			if(counts[currCity] >= 0) {
				for(Node adj : routes[curr.c]) {
					long nextDist = currDist + adj.dist;
						
					if(counts[adj.c] > 0) {
						q.add(new Node(adj.c, nextDist));
					}
				}
			}
		}
		
		for(int i=1; i<result.length; i++) {
			if(counts[i] > 0) {
				bw.write("-1\n");
			} else {
				bw.write(result[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}