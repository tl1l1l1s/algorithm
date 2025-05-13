import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int length = list.size();
			while(dump != 0) {
				Collections.sort(list);
				

				list.set(length-1, list.get(length-1) - 1);
				list.set(0, list.get(0)+1);
				
				dump--;
			}
			
			Collections.sort(list);
			bw.write("#" + tc + " " + (list.get(length-1) - list.get(0)) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}