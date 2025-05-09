import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in); 
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            int result = N;
            for(int i=1; i<M; i++) {
                result *= N;
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}