import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        	
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<Character> B = new HashSet<>();
        while(st.hasMoreTokens()) {
            B.add(st.nextToken().charAt(0));
        }

        for(char a : A.toCharArray()) {
        	if(B.contains(a)) {
        		sb.append(Character.toLowerCase(a));
        	} else sb.append(a);
        }
        
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}