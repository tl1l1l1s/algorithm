import java.io.*;
import java.util.*;

public class Main {
	
	static String str;
	static boolean[] isVisited;
	static BufferedWriter bw;
	
	static void sol(int start, int end) throws IOException {
		if(start < 0 || start > end || end > str.length()) {
			return;
		}
		
		int idx = start;
		String minCh = "z";
		
		for(int i=start; i<end; i++) {
			if(str.substring(i, i+1).compareTo(minCh) < 0) {
				minCh = str.substring(i, i+1);
				idx = i;
			};
		}
		
		if(!minCh.equals("z")) {
			isVisited[idx] = true;
			for(int i=0; i<isVisited.length; i++) {
				if(isVisited[i]) {
					bw.write(str.charAt(i));
				}
			}
			bw.write("\n");
			sol(idx+1, end);
			sol(start, idx);
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine();
		isVisited = new boolean[str.length()];
		sol(0, str.length());
		bw.flush();
		bw.close();
		br.close();

	}

}