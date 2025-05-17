import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 퍼펙트 셔플
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> l = new ArrayDeque<String>();
			Queue<String> r = new ArrayDeque<String>();

			String[] total = br.readLine().split(" ");
			int s = (N % 2 == 1) ? N/2+1 : N/2; // 기준점
			for(int i=0; i<N; i++) {
				if(i<s) {
					l.add(total[i]);
				} else {
					r.add(total[i]);
				}
			}
			
			bw.write("#" + tc);
			while(!l.isEmpty() && !r.isEmpty()) {
				bw.write(" " + l.poll());
				bw.write(" " + r.poll());
			}
			if(!l.isEmpty()) bw.write(" " + l.poll());
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}