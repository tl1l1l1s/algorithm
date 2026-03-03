import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        while((i = Integer.parseInt(br.readLine())) != 0) {
            bw.write(i + " ");
            int n = i;
            while(n / 10 != 0) {

                int res = 1;
                while(n != 0) {
                    res *= n % 10;
                    n /= 10;
                }

                bw.write(res + " ");
                n = res;
            }
            bw.write("\n");
            
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}