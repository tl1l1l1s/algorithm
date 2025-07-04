import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] map;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// NxN 정사각형 모양
		// 2칸 이상의 연속해서 빈 칸이 존재하면
		// 벽이나 짐이랑 닿되 
		// 가로로 누울 수 있는 자리, 세로로 누울 수 있는 자리
		
		// .을 만났을 때 =>
            // count++
            // X 만나면 count>1인 경우 res++; count = 0;
		
		N = Integer.parseInt(br.readLine());
		map = new String[N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine();
		}
		
		int count = 0;
		int result = 0;
		// 가로
		for(int i=0; i<N; i++) {
			int j = 0;
			count = 0;
					
			while(j<N) {
				if(map[i].charAt(j) == '.') {
					count++;
				} else {
					if(count > 1) {
						result++;
					}
							
					count = 0;
				}
				j++;
			}
			
			if(j==N && count > 1) result++;
		}
		bw.write(result + " ");
		
		result = 0;
		
		
		// 세로
		for(int i=0; i<N; i++) {
			int j = 0;
			count = 0;
			
			while(j<N) {
				if(map[j].charAt(i) == '.') {
					count++;
				} else {
					if(count > 1) {
						result++;
					}
					
					count = 0;
				}
				j++;
			}
			
			if(j==N && count > 1) result++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}