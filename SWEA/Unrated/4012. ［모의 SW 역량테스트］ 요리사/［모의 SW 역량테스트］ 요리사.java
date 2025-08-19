import java.io.*;
import java.util.*;
class Solution
{
	private static int N;
	private static int[][] synergy;
	private static int result;
	private static int bitmaskA;
	
	private static void combination(int start, int size) {
		if(size == N/2) {
			int bitmaskB = ((1 << N) - 1) ^ bitmaskA; // 이집합
			result = Math.min(result, Math.abs(sum(bitmaskA) - sum(bitmaskB)));
			return;
		}
		
		for(int i=start; i<N; i++) {
	        bitmaskA = bitmaskA | (1 << i); // i번째 비트 켜기
			combination(i+1, size+1);
	        bitmaskA = bitmaskA & ~(1 << i); // 백트래킹
		}
	}
	
	private static int sum(int bm) {
		int result = 0;
		for(int i=0; i<N; i++) {
	        if((bm & (1 << i)) != 0) {
	            for(int j=i+1; j<N; j++) {
	                if((bm & (1 << j)) != 0) {
	                    result += synergy[i][j];
	                    result += synergy[j][i];
	                }
	            }
	        }
		}
		return result;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		// 식성이 비슷한 손님 2명
		// 식재로 N/2개씩 나누어 A, B 
		// 식재로 i+j = 시너지 S 
		// 음식의 맛 = S들의 합
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			combination(1, 0);
			bw.write("#" + tc + " " + result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}