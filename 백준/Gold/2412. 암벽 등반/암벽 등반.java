import java.io.*;
import java.util.*;

public class Main {
	
	static class Position {
		int x;
		int id;
		
		Position(int x, int id) {
			this.x = x;
			this.id = id;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 암벽 홈 (x, y)
			// |a-x| <= 2 && |b-y| <= 2이면 이동 가능
			// y == T일 때까지 오름
		// 이동 회수를 최소로 정상에 오를 것
		
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		TreeSet<Position>[] byY = new TreeSet[T+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(byY[y] == null) {
				byY[y] = new TreeSet<Position>((a, b) -> {
					if(a.x != b.x) return Integer.compare(a.x, b.x);
					return Integer.compare(a.id, b.id);
				});
			}
			
			byY[y].add(new Position(x, i));
		}

		// dfs로 반복
		int result = Integer.MAX_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0, 0});
		
		outer:
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			int cnt = pos[2];
			
			for(int ny = y - 2; ny <= y + 2; ny++) {
				if(ny < 0 || ny > T) continue;
				
				TreeSet<Position> ts = byY[ny];
				if(ts== null || ts.isEmpty()) continue;
				
				Position lo = new Position(x - 2, Integer.MIN_VALUE);
				Position hi = new Position(x + 2, Integer.MAX_VALUE);
				
				Iterator<Position> iter = ts.subSet(lo, true, hi, true).iterator();
				while(iter.hasNext()) {
					Position nxt = iter.next();
					iter.remove();
					
					int nny = ny;
					
					if(nny == T) {
						result = cnt + 1;
						break outer;
					}
					q.add(new int[] {nxt.x, nny, cnt + 1});
				}
				
			}
		}
		
		bw.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}