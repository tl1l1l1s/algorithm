import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        for(long i=0; i<N; i++) {
            bw.write(br.readLine().toLowerCase() + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}