import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(":");

        int HH = 0;
        for(String a: arr) {
            if(Integer.parseInt(a) > 0 && Integer.parseInt(a) <= 12) {
                HH++;
            }

            if(Integer.parseInt(a) > 59) {
                HH = 0; break;
            }
        }
        
        bw.write(HH*2 + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}