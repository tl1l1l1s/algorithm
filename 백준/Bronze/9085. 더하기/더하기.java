import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int res = 0;

            for(int n=0; n<N; n++) {
                res += Integer.parseInt(st.nextToken());
            }
            bw.write(res + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}