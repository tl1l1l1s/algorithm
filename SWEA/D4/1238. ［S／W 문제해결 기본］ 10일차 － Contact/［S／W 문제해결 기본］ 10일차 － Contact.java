import java.io.*;
import java.util.*;

class Solution {
	
	static class P {
		int num;
		ArrayList<Integer> connected = new ArrayList<Integer>();
		int visited;
		
		P(int n) {
			this.num = n;
			this.visited = 0;
		}
		
		void visited(int v) {
			this.visited = v;
		}
		
		void addConnected(int c) {
			connected.add(c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 입력 받는 데이터 개수 
			int R = Integer.parseInt(st.nextToken()); // 시작점

			P[] contact = new P[101];
			for(int i=1; i<=100; i++) {
				contact[i] = new P(i);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				contact[from].addConnected(to);
			}

			int visitNum = 1;
			Queue<P> q = new ArrayDeque<P>();
			q.add(contact[R]);
			contact[R].visited(visitNum);
			
			while(!q.isEmpty()) {
				P current = q.poll();

				visitNum = current.visited;
				for(int n : contact[current.num].connected) {
					P next = contact[n];
					
					if(next.visited != 0) continue;
					
					// visit하지 않은 경우
					next.visited(visitNum+1);
					q.add(next);
				}
			}
			
			int result = 0;
			for(int i=0; i<101; i++) {
				if(contact[i] != null && contact[i].visited == visitNum) {
					result = i;
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}