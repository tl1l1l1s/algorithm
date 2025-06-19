import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashSet<Integer> S = new HashSet<>();
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
		
			String cmd = st.nextToken();
			int x;
			
			switch(cmd) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				S.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				bw.write((S.contains(x) ? "1" : "0") + "\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) {
					S.remove(x);
				} else {
					S.add(x);
				}
				break;
			case "all":
				for(int z=1; z<=20; z++) {
					S.add(z);
				}
				break;
			case "empty":
				S.clear();
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}