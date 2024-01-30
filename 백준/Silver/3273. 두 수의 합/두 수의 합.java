import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static int n, x, count = 0;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		st =  new StringTokenizer(br.readLine());
		nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);
		int sum = 0, i = 0, j = n-1;
		
		while(i<j) {
			sum = nums[i]+nums[j];
			if(sum == x) {
				count++;
				i++;
			} else if(sum>x) {
				j--;
			} else {
				i++;
			}
			
		}
		
		System.out.println(count);
		br.close();
	}

}
