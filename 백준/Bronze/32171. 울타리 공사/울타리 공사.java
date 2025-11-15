import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 마을 외곽에 울타리 설치
		// 최소 둘레의 직사각형으로 설치, 기존 울타리는 철거하고 새로 울타리 설치
		int N = Integer.parseInt(br.readLine());
		
		int x1 = 10, x2 = -10, y1 = 10, y2 = -10;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Math.min(x1, Integer.parseInt(st.nextToken()));
			y1 = Math.min(y1, Integer.parseInt(st.nextToken()));
			x2 = Math.max(x2, Integer.parseInt(st.nextToken()));
			y2 = Math.max(y2, Integer.parseInt(st.nextToken()));
			bw.write(Math.abs((2*(y2-y1) + 2*(x2-x1))) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}