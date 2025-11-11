import java.io.*;
import java.util.*;

public class Solution {
	static int[] boxes;
	static int min, max;
	
	static void renewM() {
		while(boxes[min] <= 0) {
			min++;
		}
		
		while(boxes[max] <= 0) {
			max--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			boxes = new int[101];
			Arrays.fill(boxes, 0);
			
			min = 100;
			max = 0;
			for(int i=0; i<100; i++) {
				int curr = Integer.parseInt(st.nextToken());
				boxes[curr] += 1;
				min = Math.min(curr, min);
				max = Math.max(curr, max);
			}
			
			while(dump > 0) {
				if(min > 101 || max < 0 || min == max) {
					break;
				}
				
				boxes[max] -= 1; boxes[max-1] += 1;
				boxes[min] -= 1; boxes[min+1] += 1;
				dump--;
				renewM();
			}
			
			bw.write("#" + tc + " " + (max - min) + "\n");	
		}
		bw.flush();
		bw.close();
		br.close();

	}

}