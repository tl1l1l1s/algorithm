import java.io.*;
import java.util.*;

class Solution {
	
	static final int[][] drc = {
			{-1, 0}, // 0 상
			{1, 0}, // 1 하
			{0, -1}, // 2 좌
			{0, 1}, // 3 우
	};
	static int R;
	static int C;
	static char[][] cmd;
	static boolean[][][][] visited;
	
	static class State {
		int x, y, memory, dir;
		
		State(int x, int y, int mem, int dir) {
	        this.x = x; this.y = y; this.memory = mem; this.dir = dir;
	    }
	}
	
	static int checkR(int r) {
		if(r < 0) return R-1;
		else if(r >= R) return 0;
		return r;
	}
	
	static int checkC(int c) {
		if(c < 0) return C-1;
		else if(c >= C) return 0;
		return c;
	}
	

	// dfs 사용 -> 재귀로 인한 스택 깊이 제한(25,600)에 걸려서 스택오버플로우 발생
		// 재귀 : 중간 상태를 스택에 저장하므로
    // bfs 사용
	static boolean move() {
		boolean flag;
		Queue<State> q = new ArrayDeque<State>();
			// LinkedList : 각 요소마다 prev, item, next가 있어 객체 헤더까지 포함하면 오버헤드가 큼
			// ArrayDeque : 요소 수에 비해 배열의 크기가 작아 메모리 오버헤드가 적고 연속된 배열을 사용해 캐시 로컬리티 이용 해서 성능 우수
			// 자바 공식 문서에서도 ArrayDeque를 사용하라고 쓰여있음 -> 다만 자바 8? 버전에서도 지원하는지 확인 필요할 것 같음
		q.add(new State(0, 0, 0, 3));
		visited[0][0][0][3] = true;
		
		while(!q.isEmpty()) {
			flag = false;
			
			State cur = q.poll();
			int x = cur.x; int y = cur.y;
			int memory = cur.memory; int dr = cur.dir;
			
			int nX, nY;
			switch(cmd[x][y]) {
				case '@':
					return true;
				case '.':
					break;
				case '<':
					dr = 2;
					break;
				case '>':
					dr = 3;
					break;
				case '^':
					dr = 0;
					break;
				case 'v':
					dr = 1;
					break;
				case '_':
					if(memory == 0) dr = 3;
					else dr = 2;
					break;
				case '|':
					if(memory == 0) dr = 1;
					else dr =0;
					break;
				case '+':
					if(memory + 1 > 15) memory = 0;
					else memory += 1;
					break;
				case '-':
					if(memory - 1 < 0) memory = 15;
					else memory -= 1;
					break;
				case '?':
					flag = true;
					break;
				default:
					memory = cmd[x][y] - '0';
					break;
			}

			if(flag) {
				for(int i=0; i<4; i++) {
					dr = i;
					
					nX = checkR(x+drc[dr][0]);
					nY = checkC(y+drc[dr][1]);
					if(visited[nX][nY][memory][dr]) continue;
					else {
						visited[nX][nY][memory][dr] = true;
						q.add(new State(nX, nY, memory, dr));
					}
				}
			} else {
				nX = checkR(x+drc[dr][0]);
				nY = checkC(y+drc[dr][1]);
				if(!visited[nX][nY][memory][dr]) {
					visited[nX][nY][memory][dr] = true;
					q.add(new State(nX, nY, memory, dr));
				}
			}
		}
		
				
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 가장 처음 위치 = 맨 왼쪽 위의 문자
		// 이동방향에 따라 다음 문자로 이동
		// 이동 방향이 상하좌우로 바뀐다
		// 바깥으로 나가면 반대편으로 이동
		// 0~15 사이를 저장
		
		// + 더하기 - 빼기 (15초과 ->0, 0미만->15)
		// < 왼 > 오 ^ 위 v 아
		// _ 0이면 오른쪽 아니면 왼쪽
		// | 0이면 아래쪽 아니면 위쪽
		// ? 상하좌우 무작위
		// . 아무것도안함
		// @ 실행 정지 << 얘로 갈 수 있는 길이 있는지 확인한다...
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			cmd = new char[R][C];
			visited = new boolean[R][C][16][4];
			for(int i=0; i<R; i++) {
				cmd[i] = br.readLine().toCharArray();
				
				for(int j=0; j<C; j++) {
					Arrays.fill(visited[i][j][0], false);
					Arrays.fill(visited[i][j][1], false);
					Arrays.fill(visited[i][j][2], false);
					Arrays.fill(visited[i][j][3], false);
				}
			}
			
			bw.write("#" + tc + " ");
			if(move()) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}