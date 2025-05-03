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
            String str = sc.next();
            
            for(int i=1; i<=str.length(); i++) {
            	if(str.substring(0, i).equals(str.substring(i, i+i))) {
                	System.out.println("#" + test_case + " " + str.substring(0,i).length());
                    break;
                }
            }
		}
	}
}