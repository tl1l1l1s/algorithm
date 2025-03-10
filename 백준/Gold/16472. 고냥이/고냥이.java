import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		HashMap<Character, Integer> map = new HashMap<>();
		
		int start = 0;
		int end = 0;
		int max = 0;
		while(str.length() > end) {
			char curr = str.charAt(end);
			// 만약 현재 end의 값이 map에 없는 경우 추가
			if(map.getOrDefault(curr, 0) == 0) {
				map.put(curr, 1);
			} else { // end의 값이 있는 경우 +1
				map.put(curr, map.get(curr) + 1);
			}
			
			while(map.size() > N && start < end) {
				if(map.get(str.charAt(start)) == 1) { // 현 start의 알파벳이 1개 있으면 
					map.remove(str.charAt(start)); // 해당 알파벳을 map에서 제거 
				} else { 
					map.put(str.charAt(start), map.get(str.charAt(start))-1); // 아닌 경우 해당 알파벳을 한 개 줄인다
				}
				start++;
			}
			max = Math.max(end-start + 1, max);
			end++;
		}
		
		System.out.print(max);

	}

}
