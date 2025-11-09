import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 2의 보수
		// 반전 + 1을 더함
		// 32비트 기준
		String original; String complement;
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(Integer.parseInt(br.readLine())));
		
		if(sb.length()<32) {
			int x = 32 - sb.length();
			for(int i=0; i<x; i++) {
				sb.insert(0, '0');
			}
		}
		original = sb.toString();
		
		// 반전
		for(int i=0; i<32; i++) {
			sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
		}
		// 1 더하기
		int result = 0;
		
		int idx = 31;
		while(idx >= 0) {
			if(sb.charAt(idx) == '0') {
				sb.setCharAt(idx, '1');
				break;
			}
			sb.setCharAt(idx, '0');
			idx--;
		}
		complement = sb.toString();

		for(int i=0; i<32; i++) {
			if(original.charAt(i) != complement.charAt(i)) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}