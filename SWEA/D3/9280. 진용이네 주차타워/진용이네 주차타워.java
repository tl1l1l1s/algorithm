import java.io.*;
import java.util.*;

class Solution {
	static int n;
	static int[] costs;
	static int[] cars;
	static ArrayList<Integer> waiting;
	
	 // 차 빼는 함수, 차 뺀 뒤 waiting이 하나 이상 있으면 주차
	static int left(int current, int[] parking) {
		
		for(int j=0; j<n; j++) {
			if(parking[j] == current) {
				parking[j] = 0;
				if(waiting.size() > 0) {
					int curr = waiting.get(0);
					waiting.remove(0);
					return park(curr, parking);
				}
			}
		}

		return 0;
	}
	
	// 주차 함수
	static int park(int current, int[] parking) {
		for(int j=0; j<n; j++) {
			if(parking[j] == 0) { 
				parking[j] = current;
				return cars[current-1] * costs[j];
			}
		}
	
		waiting.add(current); // 주차 못 했으면 waiting 배열에 추가
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1~n까지의 주차 공간
		// 매일 아침 비어있는 상태에서 시작
		
		// 비어있는 공간 중 제일 작은 공간에 주차
		// 넘치면 대기
		// 여러 대라면 차례 기다리기
		
		// 주차요금 = 차량무게 * 주차공간당 단위 무게당 금액
		// 시간은 관계 X
		
		// 총 수입
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int result = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); 
			int m = Integer.parseInt(st.nextToken());
			
			int[] parking = new int[n]; // 밑에서 사용할 주차장 상황을 기입해둘 배열
			costs = new int[n]; // 주차 공간의 단위 무게당 요금
			for(int i=0; i<n; i++) {
				costs[i] = Integer.parseInt(br.readLine());
				parking[i] = 0; // 0 = 비어있음
			}
			
			cars = new int[m]; // 차량의 무게
			for(int i=0; i<m; i++) {
				cars[i] = Integer.parseInt(br.readLine());
			}
			
			waiting = new ArrayList<Integer>();
						
			for(int i=0; i<2*m; i++) { // 주차장 출입 순서, 양수 = 들어옴 / 음수 = 나감
				int current = Integer.parseInt(br.readLine());
				
				if(current < 0) {
					result += left(current*-1, parking);
				} else {
					result += park(current, parking);
				}
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}