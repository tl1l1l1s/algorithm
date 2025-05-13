import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			int x = 0; // current X
			int y = 0; // current Y
			outer:
			for(int i=0; i<100; i++) { // 시작점을 고를 거라 0~99까지
				result = i; // 결과 값 반환을 위한 초기값 저장
				
				x = 0; // 0부터 시작
				y = i; // i부터 시작
				
				if(map[x][y] != 1) continue; // 1이 아니면 for문 안 돌 것
				
				while(x < 100) {
					if(y < 99 && map[x][y+1] == 1) {
						// 오른쪽으로 이동할 수 있는 경우
						while(y+1 < 100 && map[x][y+1] != 0) {
							y++;
						}
						
					} else if(y > 0 && map[x][y-1] == 1) {
						// 왼쪽으로 이동할 수 있는 경우
						while(y-1 >= 0 && map[x][y-1] != 0) {
							y--;
						}
					}
					
					if(map[x][y] == 2) { // 2인 경우 탈출, 값 반환
						break outer;
					}
					x++;
				}
				
			}
			
			bw.write("#" + test_case + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}

// 개선점 : 도착점에서 출발점으로 역방향 탐색