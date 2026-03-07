import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(str.substring(length-5, length));
        
        br.close();
        bw.flush();
        bw.close();
    }
}