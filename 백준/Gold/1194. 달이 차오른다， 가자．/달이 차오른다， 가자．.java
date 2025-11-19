import java.io.*;
import java.util.*;

public class Main {

	static int[][] drc = {
			{0, 1}, {1, 0}, {-1, 0}, {0, -1}
	};
	
	static class Status {
		int x;
		int y;
		int a;
		int keys;
		
		Status(int x, int y, int a, int keys) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.keys = keys;
		}
		
		int addKey(Character key) {
			return keys | (1 << key-'a');
		}
		
		boolean hasKey(Character key) {
			return (keys & (1 << key-'a')) > 0 ? true : false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 미로
			// 빈 칸 .
			// 벽 #
			// 문 A~F
			// 열쇠 a~f
			// 민식이의 위치 0
			// 탈출구 1
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][M];
		Set<Integer>[][] isVisited = new Set[N][M];
		int sX = 0, sY = 0; // 시작지점 및 끝지점
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j);
				isVisited[i][j] = new HashSet<Integer>();
				if(maze[i][j] == '0') {
					isVisited[i][j].add(0 << 6);
					sX = i; sY = j;
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		ArrayDeque<Status> dq = new ArrayDeque<>();
		dq.add(new Status(sX, sY, 0, 0));
		while(!dq.isEmpty()) {
			Status current = dq.poll();
			int cX = current.x;
			int cY = current.y;
			int a = current.a;
			int cK = current.keys;
			
			for(int d=0; d<4; d++) {
				int nX = cX + drc[d][0];
				int nY = cY + drc[d][1];
				
				
				
				if(nX >= 0 && nX < N && nY >= 0 && nY < M // 범위 내
						&& maze[nX][nY] != '#' // 벽이 아님
						&& !(isVisited[nX][nY].contains(cK))) { // 키 들고 방문한 적 없음
					
					// 방문했음 
					isVisited[nX][nY].add(cK);
					if(maze[nX][nY] == '1') {
						result = Math.min(a+1, result);
					}
					// 벽 - 열쇠 보유 여부 확인
					else if(maze[nX][nY] >= 'A' && maze[nX][nY] <= 'Z') {
						Character kabe = maze[nX][nY];
						if(current.hasKey(kabe)) { // 열쇠가 있는 경우에만 접근 가능
							dq.add(new Status(nX, nY, a+1, current.keys));
						}
					}
					// 열쇠 - 획득 & 이동
					else if(maze[nX][nY] >= 'a' && maze[nX][nY] <= 'z'){
						dq.add(new Status(nX, nY, a+1, (current.addKey(maze[nX][nY]))));
					} 
					// 시작점 빈 칸 - 즉시 진입
					else {
						dq.add(new Status(nX, nY, a+1, current.keys));
					}
				}
			}
		}
		
		bw.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}