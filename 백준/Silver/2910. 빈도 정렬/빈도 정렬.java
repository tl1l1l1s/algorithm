import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		LinkedHashMap<Integer, Integer> frequency = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			frequency.put(num, frequency.getOrDefault(num, 0)+1);
		}
		
		List<Integer> list = new ArrayList<>(frequency.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(frequency.get(b), frequency.get(a));
			}
		});
		
		for(int i=0; i<list.size(); i++) {
			for(int j = 0; j<frequency.get(list.get(i)); j++) {
				bw.write(list.get(i).toString() + " ");
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}