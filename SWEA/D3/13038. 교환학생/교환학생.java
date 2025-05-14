import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] a = new int[7];
			for(int i=0; i<7; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = Integer.MAX_VALUE;
			int count; // result로 넣을 현재 계산 횟수 
			int currentIdx; // 현재 idx 
			int currentN; // 
			for(int i=0; i<7; i++) {
				
				// 1로 시작하는 날부터만 for문 돌면서
				if(a[i] == 1) {
					count = 0;
					currentN = 0;
					currentIdx = i;
					
					while(currentN < n) {
						if(count >= result) {
							break;
						}
						 
						if(a[currentIdx] == 1) {
							currentN++;
						}

						count++;
						currentIdx = (currentIdx + 1)%7;
					}
					result = Math.min(result, count);
				}
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}