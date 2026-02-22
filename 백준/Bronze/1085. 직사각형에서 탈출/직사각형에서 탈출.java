import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 현수 위치
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 우측 상단 끝
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bw.write(Math.min(x, Math.min(y, Math.min(w-x, h-y))) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}