import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int aMon = sc.nextInt();
            int aDay = sc.nextInt();
            int bMon = sc.nextInt();
            int bDay = sc.nextInt();
            
            // 둘의 달이 똑같은 경우 그냥 day만 빼면 된다
            // 둘의 달이 다른 경우 12/31 - 8/12인 경우
            // result + bDay만큼을 추가(+31)
            // 이후 11, 10, 9까지의 달 + 막달 (8월 총 날짜 - aday)
            int result = 0;
            if(aMon == bMon) {
                result += bDay - aDay;
            } else {
                for(int i=bMon-1; i>aMon; i--) {
                	result += month[i];
                }
                result += bDay;
                result += month[aMon] - aDay;
			}
            System.out.println("#" + test_case + " " + (result+1));
		}
    }
}