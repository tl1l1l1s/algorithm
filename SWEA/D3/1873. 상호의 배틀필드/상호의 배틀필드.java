import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 배틀 필드 게임
		// . 평지
		// * 벽돌
		// # 강철
		// - 물 (접근 X)
		// ^ v < > 전차
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int cH = 0;
			int cW = 0;
			
			char[][] map = new char[H][W];
			for(int h=0; h<H; h++) {
				String mapLine = br.readLine();
				for(int w=0; w<W; w++) {
					map[h][w] = mapLine.charAt(w);
					
					if(map[h][w] == '<' ||
							map[h][w] == '^' ||
							map[h][w] == 'v' ||
							map[h][w] == '>') {
						cH = h;
						cW = w;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String cmdLine = br.readLine();
			for(int i=0; i<N; i++) {
				char cmd = cmdLine.charAt(i);
				
				switch(cmd) {
				case 'U': // U : 위로 변경, 위가 평지면 이동
					if(cH-1 >= 0 && map[cH-1][cW] == '.') {
						map[cH][cW] = '.';
						map[cH-1][cW] = '^';
						cH-=1;
					} else {
						map[cH][cW] = '^';
					}
					break;
				case 'D': // D : 아래로 변경, 평지면 이동
					if(cH+1 < H && map[cH+1][cW] == '.') {
						map[cH][cW] = '.';
						map[cH+1][cW] = 'v';
						cH+=1;
					} else {
						map[cH][cW] = 'v';
					}
					break;
				case 'L': // L : 왼
					if(cW-1 >= 0 && map[cH][cW-1] == '.') {
						map[cH][cW] = '.';
						map[cH][cW-1] = '<';
						cW-=1;
					} else {
						map[cH][cW] = '<';
					}
					break;
				case 'R': // R : 오
					if(cW+1 < W && map[cH][cW+1] == '.') {
						map[cH][cW] = '.';
						map[cH][cW+1] = '>';
						cW+=1;
					} else {
						map[cH][cW] = '>';
					}
					break;
				case 'S': // S : 포탄발싸!!
					char tank = map[cH][cW];
					
					int temp;
					if(tank == '^') {
						temp = cH-1;
						while(temp >= 0) {
							if(map[temp][cW] == '#') break;
							if(map[temp][cW] == '*') {
								map[temp][cW] = '.';
								break;
							}
							temp--;
						}
					} else if(tank == '>') {
						temp = cW+1;
						while(temp < W) {
							if(map[cH][temp] == '#') break;
							if(map[cH][temp] == '*') {
								map[cH][temp] = '.';
								break;
							}
							temp++;
						}
					} else if(tank == 'v') {
						temp = cH+1;
						while(temp < H) {
							if(map[temp][cW] == '#') break;
							if(map[temp][cW] == '*') {
								map[temp][cW] = '.';
								break;
							}
							temp++;
						}
					} else if(tank == '<') {
						temp = cW-1;
						while(temp >= 0) {
							if(map[cH][temp] == '#') break;
							if(map[cH][temp] == '*') {
								map[cH][temp] = '.';
								break;
							}
							temp--;
						}
					}
					break;
				}
			}
			
			bw.write("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					bw.write(map[i][j]);
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}