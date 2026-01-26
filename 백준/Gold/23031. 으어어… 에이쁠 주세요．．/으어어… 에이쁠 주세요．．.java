import java.io.*;
import java.util.*;

public class Main {
	
	static final String blackOut = "Aaaaaah!";
	static final String survive = "Phew...";
	static final int[][] drc = {
			{1, 0}, // 0 하 
			{0, 1},  // 1 우
			{-1, 0},  // 2 상
			{0, -1}, // 3 좌
			{1, -1},
			{1, 1},
			{-1, 1},
			{-1, -1},
	};
	static int N;
	static char[][] map; // 맵 관련 고정된 정보
	static boolean[][] switchMap; // 불 켜진 칸
	static int[][] zombiesCnt; // 칸 내의 좀비 수
	static List<Zombie> zombies; // 좀비 개별 상태
	
	static class Zombie {
		int r;
		int c;
		int drc; // 1=하, -1=상
		
		Zombie(int r, int c, int drc) {
			this.r = r;
			this.c = c;
			this.drc = drc;
		}
	}
	
	static boolean checkAhriAlive(int x, int y) {
		if(zombiesCnt[x][y] > 0 && !switchMap[x][y]) {
			return false;
		}
		return true;
	}
	
	static void turnSwitchOn(int x, int y) {
		switchMap[x][y] = true;
		for(int i=0; i<8; i++) {
			int nX = x + drc[i][0];
			int nY = y + drc[i][1];
			
			if(nX >= 0 && nX < N && nY >= 0 && nY < N) {
				switchMap[nX][nY] = true;
			}
		}
	}
	
	static void moveZombies() {
		
		for(Zombie z : zombies) {
	        int nr = z.r + z.drc; // 1(하), -1(상)

	        if (nr < 0 || nr >= N) {
	            z.drc *= -1;
	            continue;
	        }

	        zombiesCnt[z.r][z.c]--;
	        z.r = nr;
	        zombiesCnt[z.r][z.c]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// F = 앞으로 1칸, L = 좌 90도 전환, R = 우 90도 전환
		// map
			// 0 = 빈 칸
			// S = 스위치, 켤 경우 상하좌우대각선 밝힘
			// Z = 좀비
		boolean result = true;
		N = Integer.parseInt(br.readLine());
		String A = br.readLine();
		
		map = new char[N][N];
		switchMap = new boolean[N][N];
		zombiesCnt = new int[N][N];
		zombies = new ArrayList<>();
		for(int i=0; i<N; i++) {
			Arrays.fill(zombiesCnt[i], 0);
			
			String AC = br.readLine();
			
			for(int j=0; j<N; j++) {
				char c = AC.charAt(j);
				
				if(c == 'Z') {
					zombiesCnt[i][j] += 1;
					zombies.add(new Zombie(i, j, 1));
					map[i][j] = 'O';
				} else {
					map[i][j] = c;
				}
			}
			
		}
		
		int d = 0, x = 0, y = 0; // 방향, x 위치, y 위치
		for(char a : A.toCharArray()) {
			d = (d + 4) % 4;
			
			if(a == 'F') {
				if(x + drc[d][0] >= 0 && x + drc[d][0] < N
					&& y + drc[d][1] >= 0 && y + drc[d][1] < N) {
					x += drc[d][0];
					y += drc[d][1];
					
//					bw.write("현재 아리는... [" + x + "][" + y + "]\n");
//					
//					for(int i =0; i<N; i++) {
//						for(int j =0; j<N; j++) {
//							bw.write(map[i][j] + " ");	
//						}
//						bw.write("\n");
//					}
				}
			} else if(a == 'L') {
				d += 1;
			} else if(a == 'R') {
				d -= 1;
			}

			if(map[x][y] == 'S') {
				turnSwitchOn(x, y);
			}
			
			if(!(result = checkAhriAlive(x, y))) {
				break;
			}
			
			moveZombies();
			if(!(result = checkAhriAlive(x, y))) {
				break;
			}
		}
		
		bw.write((result ? survive : blackOut) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}