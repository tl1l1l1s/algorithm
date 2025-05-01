// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
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
			int P = sc.nextInt(); // A사의 리터당 요금
			int Q = sc.nextInt(); // B사의 R리터 이하 요금
			int R  = sc.nextInt();
			int S = sc.nextInt(); // B사 R리터 이상일 시 리터당 요금
			int W = sc.nextInt(); // 사용한 물 리터

            int a = P * W;
            int b = Q;
            if(W > R) {
                b += (W - R) * S;
            }
            System.out.println("#" + test_case + " " + Math.min(a, b));
        }
    }
}