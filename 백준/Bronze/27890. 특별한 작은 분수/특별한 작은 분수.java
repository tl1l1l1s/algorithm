import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정수 시각 t에서의 수 높이 xt
		// xt+1은 t가 짝수면 (xt/2).floor XOR 6
		// 			홀수면 (xt)*2 XOR 6
		
		int x0 = Integer.parseInt(st.nextToken());
		int N =  Integer.parseInt(st.nextToken());
		int result = x0;
		for(int i=1; i <= N; i++) {
			if(result == 0 || result%2 == 0) {
				result = (result/2) ^ 6;
			} else result = (result*2) ^ 6;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}