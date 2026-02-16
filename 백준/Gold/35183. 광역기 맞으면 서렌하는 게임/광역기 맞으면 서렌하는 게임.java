import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 광역맞으면서렌함
		
		// 수직선 상 하나의 수로 표현
		// N-1초 진행
		// 1초에 1 번씩 총 N개 광역기 사용
		// 회피 : L 이상 R 이하 범위 내에 있을 것
		// 첫 위치 자유
		// 게임 시작 후 1초에 최대 1 이동
		// 천상의 보호막 - 한 번 회 피 가능 
		
		int N = Integer.parseInt(br.readLine());
		
		int[] L = new int[N];
        int[] R = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            R[i] = Integer.parseInt(st.nextToken());
        }
		
        int[] dp = new int[1001];
        Arrays.fill(dp, INF);
        
        for (int p = 1; p <= 1000; p++) {
            dp[p] = (p >= L[0] && p <= R[0]) ? 0 : 1;
        }
        
        for (int t = 1; t < N; t++) {
            int[] ndp = new int[1001];
            Arrays.fill(ndp, INF);

            for (int p = 1; p <= 1000; p++) {
                if (dp[p] >= INF) continue;

                for (int d = -1; d <= 1; d++) {
                    int np = p + d;
                    
                    if (np < 1 || np > 1000) continue;

                    int miss = (np >= L[t] && np <= R[t]) ? 0 : 1;
                    int v = dp[p] + miss;
                    if (v < ndp[np]) ndp[np] = v;
                }
            }
            dp = ndp;
        }
		
		boolean res = false;
		for (int p = 1; p <= 1000; p++) {
            if (dp[p] <= 1) { res = true; break; }
        }

		bw.write(res ? "World Champion" : "Surrender");
		bw.flush();
		bw.close();
		br.close();

	}

}