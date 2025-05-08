import java.util.*;
import java.io.*;

class Solution
{
    static int[] getNums(String codeLine) {
		int[] result = new int[8];
		int idx = 0;
		
		for(int i=7; i<=56; i+=7) {
			switch(codeLine.substring(i-7, i)) {
				case "0001101":
					result[idx++] = 0;
					break;
				case "0011001":
					result[idx++] = 1;
					break;
				case "0010011":
					result[idx++] = 2;
					break;
				case "0111101":
					result[idx++] = 3;
					break;
				case "0100011":
					result[idx++] = 4;
					break;
				case "0110001":
					result[idx++] = 5;
					break;
				case "0101111":
					result[idx++] = 6;
					break;
				case "0111011":
					result[idx++] = 7;
					break;
				case "0110111":
					result[idx++] = 8;
					break;
				case "0001011":
					result[idx++] = 9;
					break;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 암호코드는 숫자 8개
		// 숫자 하나 = 7개의 비트 == 가로길이 56
		// 올바른 암호 코드 = (홀수 자리 합 * 3) + 짝수 자리 합 = 10의 배수
		// 맞으면 모든 자리의 합 반환, 아닐 시(10의 배수가 아니면) 0 반환
		int T = Integer.parseInt(br.readLine());
		for(int c = 1; c <= T; c++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[] arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			int[] code = new int[8];
			check:
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i].charAt(j) == '1') { // 끝은 무조건 1로 끝나므로 1로 끝날 때까지
						if(j+56 < M) {
							while(arr[i].charAt(j + 56) != '1') {
								j -= 1;
							}
						}
						code = getNums(arr[i].substring(j+1, j+57));
						break check;
					}
				}
			}
			
			int odd = 0, even = 0;
			for(int i=0; i<8; i++) {
				if(i%2 == 0) {
					odd += code[i];
				} else {
					even += code[i];
				}
			}
			
			bw.write("#" + c + " " + (((odd*3)+ even)%10 == 0 ? odd+even : 0) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}