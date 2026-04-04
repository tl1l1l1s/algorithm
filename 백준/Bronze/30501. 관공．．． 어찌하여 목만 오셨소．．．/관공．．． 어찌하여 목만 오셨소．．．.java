import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag = true;
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            String name = br.readLine();

            if(flag) {
             for(char c:name.toCharArray()) {
                if(c == 'S') {
                    bw.write(name + "\n");
                    flag = false;
                    break;
                }
            }   
            }
            
        }
        br.close();
        bw.flush();
        bw.close();
    }
}