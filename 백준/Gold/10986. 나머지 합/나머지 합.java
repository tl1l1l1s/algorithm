import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] cnt = new int[M];
		int sum = 0;
		cnt[0] = 1; // 아무것도 고르지 않는 경우
		for(int i=1; i<=N; i++) {
			sum = (sum + Integer.parseInt(st.nextToken())) % M;
			cnt[sum]++; // 같은 나머지로 나오는 것의 개수를 구한다
		}
		
		long result = 0; // 나머지가 0인 경우
		for(int i=0; i<cnt.length; i++) {
			// ( S[j] - S[i] ) % M == 0
			// S[j] % M == S[i] % M
			// -> 각 구간합이 같은 것끼리의 2개씩의 조합을 구한다
			result += (long)cnt[i] * (cnt[i]-1) / 2;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}