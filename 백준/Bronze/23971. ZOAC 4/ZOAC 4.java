import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken()); // 테이블 W개
		int W = Integer.parseInt(st.nextToken()); // H행
		int N = Integer.parseInt(st.nextToken()); // 비워야 할 세로
		int M = Integer.parseInt(st.nextToken()); // 비워야 할 가로

		// 1. 한 줄에 몇 명 들어가냐
		// 2. 해당 줄을 몇 번 반복할 수 있는가
		
		int result = 1;
        if(W / (M+1) != 0) {
        	if(W % (M+1) >= 1) {
				result = W / (M+1) + 1;
			} else {
				result = W / (M+1);
			}
        }
        
		if(H / (N+1) != 0) {
            if(H % (N+1) >= 1) {
    			result *= H / (N+1) + 1;
    		} else {
    			result *= H / (N+1);
    		}
        }
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}