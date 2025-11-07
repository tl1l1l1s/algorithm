import java.io.*;
import java.util.*;

public class Main {
	static int r1, c1, r2, c2;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1, 2, 3, ... 순서대로 반시계 방향 소용돌이 작성

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		// 입력은 r1, c1, r2, c2, 가운데가 (0, 0)
		map = new int[r2-r1+1][c2-c1+1];
		int max = 0;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				int rR = r1+i; int rC = c1+j; // index가 아닌 실제 배열에서의 R, C 값
				int level = Math.max(Math.abs(rR), Math.abs(rC)); // 현재 lvl 값
				int pivot = ((2 * level)+ 1) * ((2 * level)+ 1); // (lvl, lvl)의 값
				
				if(rR == level) {
					map[i][j] = pivot - (level - rC);
					
				} else if(rR == -level) {
					pivot -= (level*2)*2;
					map[i][j] = pivot - (level + rC);
				} else {
					if(rC == level) {
						pivot -= (level*2)*3;
						map[i][j] = pivot - (level + rR);
					} else if(rC == -level) {
						pivot -= level*2;
						map[i][j] = pivot - (level - rR);
					}
				}
				max = Math.max(max, map[i][j]);
			}
		}

		int digit = Integer.toString(max).length();
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				for(int k=0; k< digit - Integer.toString(map[i][j]).length(); k++) {
					bw.write(" ");
				}
				
				bw.write(map[i][j] + "");
				if(j != map[0].length-1) {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}