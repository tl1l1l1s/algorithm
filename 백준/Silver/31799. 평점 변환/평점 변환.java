import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//평어 가운데 하나 -> B/D/P
		// C+, C0, C- = B
		// B0, B-
			// 이전 학기 C~ = D
			// 이전 학기 C 아님 = B
		// A-, B+ 
			// 이전 학기 B0. B-, C+, C0, C- = P
			// A+~B+ = D
		// A0
			// 이전 학기 A-~ = E
			// 이전 학기 A+, A0 = P
		// A+ = E
		
		int N = Integer.parseInt(br.readLine());
		String scores = br.readLine();
		
		int i = 0;
		String currentScore = "";
		String prevScore = "";
		while(i < scores.length()) {
			
			if(i == scores.length()-1 || (scores.charAt(i + 1) >= 'A' && scores.charAt(i + 1) <= 'C')) {
				currentScore = scores.substring(i, i+1);
			} else {
				currentScore = scores.substring(i, i+2);
				i++;
			}
			
			// C+, C0, C-
			if(currentScore.charAt(0) == 'C') {
				sb.append('B');
			}
			// A+
			else if(currentScore.equals("A+")) {
				sb.append('E');
			}
			// B0, B-
			else if(currentScore.startsWith("B") &&
					!currentScore.equals("B+")) {
				// 첫 학기 혹은 C+, C0, C-인 경우
				if(prevScore.equals("") || prevScore.startsWith("C")) {
					sb.append("D");
				} else {
					sb.append("B");
				}
			}
			// A-, B+
			else if(currentScore.equals("A-") || 
					currentScore.equals("B+")) {
				// 이전 학기가 A-, A0, A+, B+인 경우
				if(prevScore.startsWith("A") || prevScore.equals("B+")) {
					sb.append("D");
				} else {
					sb.append("P");
				}
			}
			// A0
			else {
				// A+, A0 가운데 하나이면
				if(prevScore.startsWith("A") && !prevScore.equals("A-")) {
					sb.append('P');
				} else {
					sb.append('E');
				}
			}

			i++;
			prevScore = currentScore;
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}