import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine(), ":");
		
			String H = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			String M = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			String S = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			
			while(H.length() < 6) {
				H = "0" + H;
			}
			while(M.length() < 6) {
				M = "0" + M;
			}
			while(S.length() < 6) {
				S = "0" + S;
			}
			
			// 1. 3열 방식으로 읽은 
			for(int i=0; i<6; i++) {
			    bw.write("" + H.charAt(i) + M.charAt(i) + S.charAt(i));
			}
			
			// 2. 3행 방식으로 읽은
			bw.write(" " + H + M + S + "\n");
				
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}