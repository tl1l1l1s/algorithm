import java.io.*;
import java.util.*;

class Solution {
	
	static int K;
	static int len;
	static ArrayList<Integer> tree;
	static ArrayList<Integer>[] result;
	
	static void solution(int s, int e, int d) {
		if(d==K-1 || s==e || // s==e이면 마지막이라 그냥 추가, d==K-1이면 끝나는 지점이라 사실상 동일한 조건이긴 함
				s < 0 || e > len) { // index error
			result[d].add(tree.get(s));
			return;
		}
		
		int mid = (s+e) / 2;
		result[d].add(tree.get(mid));
		
		solution(s, mid-1, d+1);
		solution(mid+1, e, d+1);
		return;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 완전 이진 트리 - 중위 순회
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			K = Integer.parseInt(br.readLine());
			len = (int) Math.pow(2, K) - 1;
			
			tree = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<len; i++) {
				tree.add(Integer.parseInt(st.nextToken()));
			}
			
			result = new ArrayList[K];
			for(int i=0; i<K; i++) {
				result[i] = new ArrayList<Integer>();
			}
			
			// 처음엔 반으로 분할 , 반 인덱스에 있는 값 = 1 
				// 이후 분할된 곳 기준 가운데 값을 프린트
				// 값이 하나 남으면 쭉 프린트 = 마지막 값
			solution(0, len, 0);
			
			bw.write("#" + tc + " ");
			for(int i=0; i<K; i++) {
				for(int j=0; j<result[i].size(); j++) {
					bw.write(result[i].get(j) + " ");
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}