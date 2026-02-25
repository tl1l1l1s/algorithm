import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int m=0; m<M; m++) br.readLine();

            bw.write(N-1 + "\n");
        }
        
		bw.flush();
		bw.close();
		br.close();
    }
}