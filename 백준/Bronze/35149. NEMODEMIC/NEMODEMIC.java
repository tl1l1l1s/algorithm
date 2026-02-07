import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 난이도 1 = 벽 1개 이하, 한 방향 바이러스 1개 이하, 모든 방향 바이러스 0개
		// 난이도 2 = 벽 2개 이상, 한 방향 바이러스 2개 이상, 모든 방향 바이러스 0개
		// 난이도 3 = 모든 방향 바이러스 0개, 백신 존재
		// 난이도 4 = 모든 방향 바이러스 존재
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		
		int start = 0, end = 0;
		int wall = 0;
		int directionalVirus = 0;
		int vaccine = 0;
		int allVirus = 0;
		for(int n=0; n<N; n++) {
			String str = br.readLine();
		
			for(int m=0; m<M; m++) {
				switch(str.charAt(m)) {
				case 'S' : start++;break;
				case 'E' : end++; break;
				case '#' : wall++; break;
				case '.' : break;
				case 'A' : allVirus++; break;
				case 'V' : vaccine++; break;
				default: directionalVirus++; break;
				}
			}
			
		}
		

		if(start == 1 && end == 1) {
			if(allVirus == 0) {
				if(vaccine == 0) {
					if(directionalVirus <= 1 && wall <= 1) {
						bw.write("1\n");
					} else {
						bw.write("2\n");
					}
				} else {
					bw.write("3\n");
				}
			} else {
				bw.write("4\n");
			}
		} else {
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}