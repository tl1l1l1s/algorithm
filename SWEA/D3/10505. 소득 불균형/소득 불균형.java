import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] incomes = new int[N];
            int result = 0;
            int avg = 0;
            for(int i=0; i<N; i++) {
            	incomes[i] = sc.nextInt();
                avg += incomes[i];
            }
            avg/=N;
            for(int income : incomes) {
            	if(income <= avg) result++;
            }
            
			bw.write("#" + test_case + " " + result + "\n");
		}
        
        bw.flush();
        bw.close();
	}
}