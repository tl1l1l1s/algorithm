import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            sb.append(st.nextToken());
        }
        long a = Long.parseLong(sb.toString());

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            sb.append(st.nextToken());
        }
        long b = Long.parseLong(sb.toString());
        
        bw.write(Math.min(a, b) + "\n");
		bw.flush();
		bw.close();
		br.close();
    }
}