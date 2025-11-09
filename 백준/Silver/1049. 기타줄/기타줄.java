import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 기타 줄 (6 혹은 1+@)
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int set = Integer.MAX_VALUE, each = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			set = Math.min(set, Integer.parseInt(st.nextToken()));
			each = Math.min(each, Integer.parseInt(st.nextToken()));
		}
		
		int result = 0;
		if(each * 6 < set) {
			result = each * N;
		} else {
			result = Math.min((set * (N/6)) + (each * (N%6)), 
					set * (N/6 + 1));
		}
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}