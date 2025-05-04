import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= tc; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int speed = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				
				switch(cmd) {
				case 0 :
					result += speed;
					break;
				case 1 :
					speed += Integer.parseInt(st.nextToken());
					result += speed;
					break;
				case 2 :
					speed -= Integer.parseInt(st.nextToken());
					speed = (speed>0 ? speed : 0);
					result += speed;
					break;
				}
			}
			bw.write("#" + test_case + " " + result + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
}