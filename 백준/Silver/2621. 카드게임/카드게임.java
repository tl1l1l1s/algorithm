import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 카드게임
		// R B Y G 1~9 = 총 36장
		
		// 카드가 모두 같은 색 + 연속적 = 가장 높은 숫자 + 900
		
		// 5장의 색상 동일 가장 높은 숫자 + 600
		
		// 5장의 숫자 연속 가장 높은 숫자 + 500
		
		// 4장의 숫자가 같으면 같은 숫자 + 800
		// 3장의 숫자 동일, 2장의 숫자 동일 = 3장 * 10 + 2장 + 700
		// 3장의 숫자가 같으면 같은 숫자 + 400
		// 2장의 숫자 동일, 2장의 숫자 동일 = 큰 숫자 * 10 + 작은 숫자 + 300
		// 2장의 숫자 동일 = 같은 숫자 + 200
		
		// 어떤 경우에도 해당 X = 가장 큰 숫자 + 100
		
		char[] colors = new char[5];
		int[] nums = new int[5];
		HashMap<Character, Integer> charMap = new HashMap<>();
		HashMap<Integer, Integer> numMap = new HashMap<>();
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			colors[i] = st.nextToken().charAt(0);
			nums[i] = Integer.parseInt(st.nextToken());
			charMap.put(colors[i], charMap.getOrDefault(colors[i], 0) + 1);
			numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
		}
		
		int result = 0;
		boolean isContinuous = true;
		Arrays.sort(nums);
		for(int i=1; i<5; i++) {
			if(nums[i] != nums[i-1] + 1) {
				isContinuous = false;
				break;
			}
		}
		
		if(charMap.size() == 1) { // 전 카드 색상 동일
			if(isContinuous) { // 연속적
				result = 900 + nums[4];
			} else { // 연속적 X
				result = 600 + nums[4];
			}
		}
		
		if(isContinuous) { // 연속적
			result = Math.max(result, 500 + nums[4]); 
		} else { // 연속적 X
			Set<Integer> keys = numMap.keySet();
			if(numMap.size() == 2) {
				if(numMap.containsValue(4)) { // 4, 1
					for(int key : keys) {
						if(numMap.get(key) == 4) {
							result = Math.max(result, 800 + key);
						}
					}
				} else { // 3, 2
					int temp = 0;
					for(int key : keys) {
						if(numMap.get(key) == 3) {
							temp += key * 10;
						} else {
							temp += key + 700;
						}
					}
					result = Math.max(result, temp);
				}
			} else if(numMap.size() == 3){
				if(numMap.containsValue(3)) { // 3, 1, 1
					for(int key : keys) {
						if(numMap.get(key) == 3) {
							result = Math.max(result, 400 + key);
						}
					}
				} else { // 2, 2, 1
					int n1 = -1, n2 = -1;
					for(int key : keys) {
						if(numMap.get(key) == 2) {
							if(n1 == -1) {
								n1 = key;
							} else {
								n2 = key;
								break;
							}
						}
					}
					result = Math.max(result, (Math.max(n1, n2) * 10) + Math.min(n1, n2) + 300);
				}
			} else if(numMap.size() == 4) { // 2, 1, 1, 1
				for(int key : keys) {
					if(numMap.get(key) == 2) {
						result = Math.max(200 + key, result);
					}
				}
			} else {
				result = Math.max(nums[4] + 100, result);
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}