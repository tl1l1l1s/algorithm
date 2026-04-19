import java.io.*;
import java.util.*;

public class Main {
	
	static class Sub implements Comparable<Sub>{
		int x;
		int times;
		
		Sub(int x, int times) {
			this.x = x;
			this.times = times;
		}
		
		Sub(int x) {
			this.x = x;
			this.times = 0;
		}

		@Override
		public int compareTo(Sub o) {
			return this.times - o.times;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[100001];
		Arrays.fill(dist, -1);		
		dist[N] = 0;
		PriorityQueue<Sub> pq = new PriorityQueue<>();
		pq.add(new Sub(N, 0));
		
		while(!pq.isEmpty()) {
			Sub current = pq.poll();
			int cX = current.x;
			int cT = current.times;
			
			if(cX == K) {
				bw.write(dist[K] + "");
				break;
			}
			
			if(cX * 2 <= 100000) {
				if(dist[cX*2] == -1 || dist[cX*2] > cT) {
					dist[cX * 2] = cT;
					pq.offer(new Sub(cX*2, cT));
				}
			}
			
			if(cX - 1 >= 0) {
				if(dist[cX-1] == -1 || dist[cX-1] > cT+1) {
					dist[cX-1] = cT + 1;
					pq.offer(new Sub(cX-1, cT+1));
				}
			}
			
			if(cX + 1 <= 100000) {
				if(dist[cX+1] == -1 || dist[cX+1] > cT+1) {
					dist[cX+1] = cT + 1;
					pq.offer(new Sub(cX+1, cT+1));
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}