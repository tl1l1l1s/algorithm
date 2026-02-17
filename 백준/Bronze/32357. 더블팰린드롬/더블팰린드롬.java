import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		int N = Integer.parseInt(br.readLine());
		
		// 더블팰린드롬 현상을 일으킬 수 있는 쌍의 개수
		int res = 0;
		for(int n=0; n<N; n++) {
			sb = new StringBuilder();
			String str = br.readLine();
			sb.append(str.substring(str.length()/2, str.length())).reverse();
			if(sb.toString().equals(str.substring(0, str.length()/2))) {
				res++;
			}
		}
		
		bw.write((res * (res-  1)) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}