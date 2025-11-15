import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] hamburger;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
		
			int[][] ingredients = new int[N+1][2];
			hamburger = new int[N+1][L+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken()); // 점수
				ingredients[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			Arrays.fill(hamburger[0], 0); 
			for(int i=1; i<=N; i++) {
				hamburger[i][0] = 0;
				
				for(int c=1; c<=L; c++) {
					if(ingredients[i][1] <= c) {
						hamburger[i][c] = Math.max(hamburger[i-1][c], // i번 재료를 제외했을 때 + w 무게일 때의 만족도 
								hamburger[i-1][c-ingredients[i][1]] + ingredients[i][0]); // i-1번 재료 + w-iW 무게일 때의 만족도 + 현재 재료의 만족도
					} else {
						hamburger[i][c] = hamburger[i-1][c];
					}
				}
			}
			
			bw.write("#" + tc + " " + hamburger[N][L] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}