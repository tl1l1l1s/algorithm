import java.util.*;
import java.io.*;

class Main {
    static long MOD = 987654321L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int n = N/2;
        long[] dp = new long[n + 1]; // dp[n] = 사람 2n명을 악수 선이 교차하지 않는 수
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            long sum = 0;

            for(int j=0; j<=i-1; j++) {
                sum = (sum + (dp[j] * dp[i - 1 - j] % MOD)) % MOD;
            }
            dp[i] = sum;
        }
        
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}