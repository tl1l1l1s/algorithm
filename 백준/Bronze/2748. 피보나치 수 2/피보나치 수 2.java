import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long[] fib;
    static long sol(int k) {
        if(k <= 1) {
            return k;
        }
        
        if(fib[k] != -1) return fib[k];

        return fib[k] = (sol(k-1) + sol(k-2));
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        fib = new long[N+1];
        Arrays.fill(fib, -1);
        
        bw.write(String.valueOf(sol(N)));
        bw.flush();
        bw.close();
        br.close();
        
    }
}