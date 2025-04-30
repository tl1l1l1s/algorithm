package Solution;

import java.util.*;
import java.io.*;

public class sw1986 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int result = 0;
            for(int i=1; i<=N; i++) {
             	if(i % 2 == 0) {
                    result -= i;
                } else {
                    result += i;
            }
		}
            
            bw.write("#" + test_case + " " + result + "\n");
		}
        bw.flush();
        bw.close();
    }
}