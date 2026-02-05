import java.io.*;
import java.util.*;

public class Main {
	
	static int count(int x) {
	    int cnt = 0;
	    do {
	        cnt++;
	        x /= 10;
	    } while (x != 0);
	    return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		
		int f = 1;
		int nxt = 0;
		int total = 0;
		boolean res = true;
		
		for(int kx = 1; kx < 4; kx++) {
			if(kx > str.length()) {
				break;
			}
			f = Integer.parseInt(str.subSequence(0, kx).toString());
			
			int idx = count(f);
			total = idx;
			nxt = f + 1;
			res = true;
			
			while(idx + count(nxt) <= str.length()) {
				if(Integer.parseInt(str.subSequence(idx, idx + count(nxt)).toString()) != nxt) {
					res = false;
					break;
				}
				
				idx += count(nxt);
				total += count(nxt);
				nxt++;
			}
			
			if(res && total == str.length()) {
				bw.write(f + " " + (nxt-1));
				break;
			}
		}
		
		if(!res || (res && total != str.length())) {
			bw.write(f + " " + f);
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}