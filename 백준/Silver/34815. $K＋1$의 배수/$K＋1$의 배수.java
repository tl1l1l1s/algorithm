import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 양의 정수 N, K
		// 1 이상 N 이하의 정수 중 서로 다른 K개의 정수선택
		// K 개의 정수 합 = K+1의 배수가 되게 하는 게 가능한지
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (N > K) {
			bw.write("YES");
		} else { // N == K
			bw.write((K % 2 == 0) ? "YES" : "NO");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}