import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		int result = 0;		
		int min = 1; // 뺄 값
		
		int len = 0, wid = 0;
		
		int[] drc = new int[6];
		int[] dis = new int[6];
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			drc[i] = Integer.parseInt(st.nextToken());
			dis[i] = Integer.parseInt(st.nextToken());
			
			if(drc[i] == 1 || drc[i] == 2) {
				wid = Math.max(wid, dis[i]);
			} else {
				len = Math.max(len, dis[i]);
			}
		}
		
		for(int i=0; i<6; i++) {
			if(drc[(i+5)%6] == drc[(i+1)%6]) {
				if(drc[(i+2)%6] == drc[i]) {
					min = dis[i] * dis[(i+1)%6];	
				} else {
					min = dis[i] * dis[(i+5)%6];				
				}

			}
		}
		
		result = (wid * len)- min;
		bw.write((result)*K + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}