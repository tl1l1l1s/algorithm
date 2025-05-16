import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 상자 N개
		// Q회동안 일정 범위의 상자를 동일 숫자로 변경
		// L~R번 상자를 i로 변경
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = 0;
			}
			
			for(int q=1; q<=Q; q++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				for(int i=L; i<=R; i++) {
					arr[i] = q;
				}
			}
			
			bw.write("#" + tc);
			for(int i=1; i<=N; i++) {
				bw.write(" " + arr[i]);
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}