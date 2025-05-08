import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1000명의 수학 성적 통계자료
		// 최빈수 = 가장 여러 번 나타나는 값 

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
			
			br.readLine(); // tc와 동일
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<1000; i++) {
				int current = Integer.parseInt(st.nextToken());
				hs.put(current, hs.getOrDefault(current, 0)+1);
			}

			int result = 0;
			int max = 0;
			Iterator<Integer> iter = hs.keySet().iterator();
			
			while(iter.hasNext()) {
				int x = iter.next();
				if(max <= hs.get(x)) {
					max = hs.get(x);
					result = x;	
				}
			}
			
			bw.write("#" + tc +  " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
    }
}