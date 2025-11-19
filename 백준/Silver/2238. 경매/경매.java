import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int U = Integer.parseInt(st.nextToken()); // 금액의 상한
		int N = Integer.parseInt(st.nextToken()); // 경매에 참여한 사람 수
		Map<Integer, Integer> proposal = new HashMap<>();
		String[] PP = new String[U+1];
		
		// 같은 가격을 제시한 사람이 둘 이상
		// 가장 적은 수의 사람이 제시한 가격 중 제일 낮은 가격 중 제일 먼저 제시한 사람
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			if(proposal.containsKey(n)) {
				proposal.put(n, proposal.get(n) + 1);
			} else {
				proposal.put(n, 1);
				PP[n] = p;
			}
		}
		
		int resIndex = 0;
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : proposal.entrySet()) {
		    int key = entry.getKey();
		    int value = entry.getValue();

		    if (value < min) {
		        min = value;
		        resIndex = key;
		    } else if (value == min) {
		        resIndex = Math.min(resIndex, key);
		    }
		}
		
		bw.write(PP[resIndex] + " " + resIndex);
		bw.flush();
		bw.close();
		br.close();

	}

}