import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());

        while(N > 0) {
            sb.append(N%2);
            N /= 2;
        }

        bw.write(sb.reverse().toString());
        br.close();
        bw.flush();
        bw.close();
    }
}