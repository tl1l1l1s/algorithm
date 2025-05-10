import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			LinkedList<Integer> pwd = new LinkedList<Integer>();
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				pwd.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				String cmd = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				switch(cmd) {
				case "I":
					for(int j=0; j<y; j++) {
						pwd.add(x+j, Integer.parseInt(st.nextToken()));
					}
					break;
					
				case "D":
					for(int j=0; j<y; j++) {
						pwd.remove(x+j);
					}
					break;
				
				case "A":
					pwd.add(y);
					for(int j=0; j<x-1; j++) {
						pwd.add(Integer.parseInt(st.nextToken()));
					}
					break;
				
				}
			}
			
			bw.write("#" + tc + " ");
			for(int i=0; i<10; i++) {
				bw.write(pwd.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}