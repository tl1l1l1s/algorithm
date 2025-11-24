import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 양의 정수 A
		// A의 모든 자리 수에 적힌 수들을 곱함
		// 한 자리 수가 될 때까지 반복, 이 한 자리 수 = 바닥수
		int N = Integer.parseInt(st.nextToken()); // 바닥수
		int L = Integer.parseInt(st.nextToken()); // P가 총 몇 자리인지

		if(N == 0) {
			bw.write("10");
		} else {
			bw.write("1" + (N/1));
		}
		
		L -= 2;
		bw.write("1".repeat(L));
		bw.flush();
		bw.close();
		br.close();

	}

}