import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int i = sc.nextInt();
    	    int j = sc.nextInt();
            
            int[] a = new int[i];
            int[] b = new int[j];
            for(int k=0; k<i; k++) {
                a[k] = sc.nextInt();
            }
            
			for(int k=0; k<j; k++) {
                b[k] = sc.nextInt();
            }
            
            // 작은 거는 작은 것만 반복하면 됨 0...끝까지
            // 큰 거를 1씩 늘려가며 
            
            int k = 0;
            int result = 0;
            if(i>j) {
                while(k+j <= i) {
                    int temp = 0;
                    for(int l=0; l<j; l++) {
                        temp += a[k+l]*b[l];
                    }
                    result = Math.max(result, temp);
                    k++;
                }
            } else {
                 while(k+i <= j) {
                    int temp = 0;
                    for(int l=0; l<i; l++) {
                        temp += a[l]*b[k+l];
                    }
                    result = Math.max(result, temp);
                    k++;
                }
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
}