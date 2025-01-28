import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cur;
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> cards = new HashMap<>();
		for(int i=0; i<N; i++) {
			cur = Integer.parseInt(st.nextToken());
			cards.put(cur, cards.getOrDefault(cur, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(cards.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
		}
		
		System.out.print(sb.toString());
	}
}
