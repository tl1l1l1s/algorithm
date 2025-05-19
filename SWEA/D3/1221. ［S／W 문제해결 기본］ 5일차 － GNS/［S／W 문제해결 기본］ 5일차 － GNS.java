import java.io.*;
import java.util.*;

class Solution {
	
	static String toNumber(String x) {
		switch (x) {
		case "ZRO":
			return "0";
		case "ONE":
			return "1";
		case "TWO":
			return "2";
		case "THR":
			return "3";
		case "FOR":
			return "4";
		case "FIV":
			return "5";
		case "SIX":
			return "6";
		case "SVN":
			return "7";
		case "EGT":
			return "8";
		case "NIN":
			return "9";
		default:
			return "-1"; // 사실상 에러
		}
	}
	
	static String toString(String x) {
		switch (x) {
		case "0":
			return "ZRO";
		case "1":
			return "ONE";
		case "2":
			return "TWO";
		case "3":
			return "THR";
		case "4":
			return "FOR";
		case "5":
			return "FIV";
		case "6":
			return "SIX";
		case "7":
			return "SVN";
		case "8":
			return "EGT";
		case "9":
			return "NIN";
		default:
			return ""; // 사실상 에러
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			String tc = st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			String[] code = new String[N];
			for(int i=0; i<N; i++) {
				code[i] = toNumber(st.nextToken());
			}
			
			Arrays.sort(code);
			
			bw.write(tc);
			for(int i=0; i<N; i++) {
				bw.write(" " + toString(code[i]));
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}