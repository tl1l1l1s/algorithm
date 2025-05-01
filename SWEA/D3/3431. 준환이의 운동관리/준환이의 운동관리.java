// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
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
            int L = sc.nextInt(); // L분 이상
            int U = sc.nextInt(); // U분 이하
            int X = sc.nextInt(); // 이번 주에 한 운동
            // 초과 -> -1, 이하 -> 얼마나 더 필요한지
            
            if(X > U) {
                System.out.println("#" + test_case + " " + -1);
            } else { // X가 U를 초과하지 않는 경우 = 운동이 얼마나 더 필요한가
                System.out.println("#" + test_case + " " + (X-L > 0 ? 0 : L-X));
            }
		}
	}
}