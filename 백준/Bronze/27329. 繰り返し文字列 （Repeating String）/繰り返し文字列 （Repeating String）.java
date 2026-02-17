import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        boolean res = true;


        if(str.substring(0, str.length()/2).equals(str.substring(str.length()/2, str.length()))) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
		bw.flush();
		bw.close();
		br.close();
    }
}