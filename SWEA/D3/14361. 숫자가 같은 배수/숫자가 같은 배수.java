import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
            Boolean flag = false;
            String N = br.readLine();
            int length = N.length();
            
            int[] hm = new int[10];
            for(int i=0; i<10; i++) {
                hm[i] = 0;
            }
            
            for(int i=0; i<length; i++) {
                hm[N.charAt(i) - '0'] += 1;
            }
            
            int n = Integer.parseInt(N);
            int[] nm;
            for(int i=2, curr = n*i; Integer.toString(curr).length()==length; curr=n*++i) {
                String current = Integer.toString(curr);
                nm = hm.clone();
                
                for(char x : current.toCharArray()) {
                	nm[x-'0'] -= 1;
                	flag = true;
                    if(nm[x-'0'] < 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    break;
                }
            }
            
            bw.write("#" + tc + " " + (flag ? "possible" : "impossible") + "\n");    
        }

        bw.flush();
        bw.close();
        br.close();

    

}
}