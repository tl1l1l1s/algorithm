import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        if(s.repeat(t.length()).equals(t.repeat(s.length()))) {
            bw.write("1");
        } else bw.write("0");
        
        br.close();
        bw.flush();
        bw.close();
    }
}