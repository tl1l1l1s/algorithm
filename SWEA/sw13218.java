package Solution;

import java.util.Scanner;

public class sw13218 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case + " " +  sc.nextInt()/3);
		}
	}

}