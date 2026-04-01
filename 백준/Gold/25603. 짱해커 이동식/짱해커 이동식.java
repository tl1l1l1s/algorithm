import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] requests = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int index = 0;

        while(index+K <= N) {
            int temp = requests[index];
            int nextIndex = index;
            
            for(int k=index+1; k<index+K; k++) {
                if(requests[k] <= temp) {
                    temp = requests[k];
                    nextIndex = k;
                }
            }

            result = Math.max(result, temp);
            index = nextIndex + 1;
        }

        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}