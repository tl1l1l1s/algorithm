import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 2^x + 2^y = m인 x, y (x<=y)		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int aA = -1, aB = -1;
			long m = Long.parseLong(br.readLine());
			
			for(int b=0; b<64; b++) { // long = 64 bit
				if((m & (1L << b)) != 0) {
					if(aA == -1) { // 아직 aA에 값이 없으면 
						aA = b;
					} else { 
						aB = b;
						break;
					}
				}
			}
			bw.write((aB == -1 ? ((aA-1) + " " + (aA-1))
					: (aA + " " + aB)) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}