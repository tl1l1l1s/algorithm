import java.util.*;
import java.io.*;

class Solution
{
    	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[10];
			int max = -1, min = 10001;
            double sum = 0;
			for(int i=0; i<10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i]);
				sum += nums[i];
			}
			
			sum = sum - max - min;
			bw.write("#" + tc + " " + Math.round(sum/8) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}