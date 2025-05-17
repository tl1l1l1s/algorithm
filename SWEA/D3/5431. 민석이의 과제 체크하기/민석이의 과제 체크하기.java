import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1~N
		// 수강생 수 N
		// 제출자 수 K
		// K 제외하고 전부
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] except = new int[K];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				except[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(except);
			bw.write("#" + tc);
			int k=0;
			for(int i=1; i<=N; i++) {
				if(k<K && except[k] == i) {
					k++;
				} else {
					bw.write(" " + i);
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}