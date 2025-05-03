import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a >= 10 || b >= 10) {
                bw.write("#" + test_case + " " + -1 + "\n");
            } else {
                bw.write("#" + test_case + " " + (a*b) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
}