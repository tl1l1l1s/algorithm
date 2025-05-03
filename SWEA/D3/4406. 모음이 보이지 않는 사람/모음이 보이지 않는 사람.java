import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            
            str = str.replaceAll("a", new String(""));
            str = str.replaceAll("e", new String(""));
            str = str.replaceAll("i", new String(""));
            str = str.replaceAll("o", new String(""));
            str = str.replaceAll("u", new String(""));
            
            bw.write("#" + test_case + " " + str + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
}