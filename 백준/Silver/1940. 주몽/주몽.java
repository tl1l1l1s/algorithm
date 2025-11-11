import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 철기군 양성
		// 갑옷 두 개의 재료, 번호를 합쳐서 == M -> 갑옷
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> ingredients = new HashSet<>();
		for(int i=0; i<N; i++) {
			ingredients.add(Integer.parseInt(st.nextToken()));
		}
		
		int result = 0;
		Iterator<Integer> iter = ingredients.iterator();
		while(iter.hasNext()) {
			if(ingredients.contains(M - iter.next())) {
				result++;
			}
		}
		bw.write(result/2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}