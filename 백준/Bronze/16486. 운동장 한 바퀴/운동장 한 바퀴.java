import java.util.*;
import java.io.*;

class Main {
    static double pi = 3.141592;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d1 = Integer.parseInt(br.readLine()); // 직사각형 가로의 길이
        int d2 = Integer.parseInt(br.readLine()); // 반원의 반지름 길이

        bw.write(((d1*2) + (d2*2*pi)) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}