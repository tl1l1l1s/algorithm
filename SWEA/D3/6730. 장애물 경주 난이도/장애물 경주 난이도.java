import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] blocks = new int[N];
            for(int i=0; i<N; i++) {
            	blocks[i] = sc.nextInt();
            }
            
            // 그냥 int[N] 10 70 30 50 90 이 있으면
            //               0   1-0   2-1  3-2  4-3
            //                0   60   -40    20   40
            // 제일 Math.min = decline
            // 제일 Math.max = incline
            int incline = 0;
           	int decline = 0;
            for(int i=1; i<N; i++) {
                int current = blocks[i] - blocks[i-1];
				incline = Math.max(incline, current);
                decline = Math.min(decline, current);
            }
            System.out.println("#" + test_case + " " + incline + " " + Math.abs(decline));
		}
	}
}