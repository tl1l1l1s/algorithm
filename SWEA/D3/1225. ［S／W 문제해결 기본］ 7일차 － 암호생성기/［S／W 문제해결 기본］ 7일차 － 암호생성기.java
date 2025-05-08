import java.util.*;
import java.io.*;

class Solution
{
    static final int[] nums = {5, 1, 2, 3, 4}; // 0 1 2 3 4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// n개의 수를 처리, 8자리의 암호
		// 1~5까지 반복하며 빼며 뒤로 이동
		// FIFO => QUEUE
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			Queue<Integer> q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 1;
			int curr = q.poll();
			while(curr - nums[idx%5] > 0) {
				q.add(curr - nums[idx%5]);
				idx++;
				
				curr = q.poll();
			}
			
			q.add(0);
			bw.write("#" + tc + " ");	
			while(!q.isEmpty()) {
				bw.write(q.poll() + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}