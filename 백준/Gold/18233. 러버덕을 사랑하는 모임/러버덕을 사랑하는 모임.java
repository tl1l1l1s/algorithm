import java.io.*;
import java.util.*;

public class Main {
    static int N, P, E;
    static int[][] dolls;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        

        if (P > N) {
            bw.write("-1\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        dolls = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dolls[i][0] = Integer.parseInt(st.nextToken());
            dolls[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = new int[N];

        // 조합
        int[] idx = new int[P];
        for (int i = 0; i < P; i++) idx[i] = i;

        while (true) {
            if (check(idx)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    sb.append(answer[i]).append(' ');
                }
                bw.write(sb.toString() + "\n");
                bw.flush();
                bw.close();
                return;
            }

            // 다음 조합 생성
            int pos = P - 1;
            while (pos >= 0 && idx[pos] == N - P + pos) pos--;
            if (pos < 0) break;

            idx[pos]++;
            for (int i = pos + 1; i < P; i++) {
                idx[i] = idx[i - 1] + 1;
            }
        }

        bw.write("-1\n");
        br.close();
        bw.flush();
        bw.close();
    }

    // 가능한 값이 있는지 확인
    static boolean check(int[] idx) {
        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < P; i++) {
            minSum += dolls[idx[i]][0];
            maxSum += dolls[idx[i]][1];
        }

        // E가 최소값 ~ 최대값 내 범위에 있는지 확인
        if (minSum > E || maxSum < E) return false;

        int[] temp = new int[N];
        int remain = E;

        // 최소값 미리 등록
        for (int i = 0; i < P; i++) {
            int person = idx[i];
            temp[person] = dolls[person][0];
            remain -= dolls[person][0];
        }

        // 남은 부분 채우기
        for (int i = 0; i < P && remain > 0; i++) {
            int person = idx[i];
            int extra = dolls[person][1] - dolls[person][0];
            int give = Math.min(extra, remain);
            temp[person] += give;
            remain -= give;
        }

        if (remain == 0) {
            System.arraycopy(temp, 0, answer, 0, N);
            return true;
        }
        return false;
    }
}