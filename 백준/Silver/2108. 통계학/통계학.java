import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 평균 (소수 첫 째 자리에서 반올림한 값)
		// 2. 중앙값
		// 3. 최빈값 (두 번째로 작은 값)
		// 4. 최댓값 - 최솟값
		int N = Integer.parseInt(br.readLine());

		double totalSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			totalSum += num;
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		// 평균(소수 첫 번재 자리에서 반올림)
		bw.write(Math.round(totalSum/N) + "\n");

		// 중앙값
		Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
		Arrays.sort(keys);		
		int pivotIndex = -1;
		int medianIndex = 0;
		if(map.size() > 1) {
			while(medianIndex <= N/2) {
				pivotIndex++;
				medianIndex += map.get(keys[pivotIndex]); 
			}
			bw.write(keys[pivotIndex] + "\n");
		} else bw.write(keys[0] + "\n");

		// 최빈값(여러 개 있으면 두 번째로 작은 값)
		ArrayList<Integer> mode = new ArrayList<>();
		mode.add(keys[0]);
		for(int i=1; i<keys.length; i++) {
			int currMax = map.get(mode.get(0)); // 기본 비교값
			
			if(map.get(keys[i]) > currMax) { // 만약 가져온 값의 value가 현재 max 값보다 크면 비우고 바꿈 
				mode.clear();
				mode.add(keys[i]);
			} else if(map.get(keys[i]) == currMax) { // 동일하면 추가
				mode.add(keys[i]);
			} else continue;
		}
		if(mode.size() > 1) {
			Collections.sort(mode);
			bw.write(mode.get(1) + "\n");
		} else {
			bw.write(mode.get(0) + "\n");
		}
	
		// 최댓값 - 최솟값
		bw.write(keys[keys.length-1] - keys[0] + "\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}