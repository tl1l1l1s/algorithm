import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> books = new HashMap<>();
		String name;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			name = br.readLine();	
			books.put(name, books.getOrDefault(name, 0)+1);
		}
		
		// max와 비교했을 때 값이 크거나 같은 책들을 동적 배열에 집어넣는다.
        // lambda 함수 내에서 변수 값을 변경하기 위한 wrapper
		var wrapper = new Object() { int max = 0; };
		ArrayList<String> result = new ArrayList<String>();
	
		books.forEach((key, value) -> {
			if(wrapper.max < value) {
				result.clear();
				result.add(key);
				wrapper.max = value;
			} else if (wrapper.max == value) {
				result.add(key);
			}
		});
		
		// 같은 값들이 있을 경우, 사전 순으로 sorting
		if(result.size() > 1) {
			Collections.sort(result);	
		}
		System.out.println(result.get(0));
		
		br.close();
	}

}
