import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		long E = Long.parseLong(st.nextToken());
		double result = 0;
		
		long R; // 시전 대기 시간
		long A; // 시전 시간
		long D; // 총 시전 시간동안의 데미지
		double temp;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			R = Long.parseLong(st.nextToken());
			A = Long.parseLong(st.nextToken());
			D = Long.parseLong(st.nextToken());
			
			// 총 시전 횟수
			temp = ((E) / (R+A)); 
			result += (temp * D);
			
			// 남은 횟수 확인
			temp = (E) % (R+A); 
			if(temp-R > 0) {
				result += ((double)D/A) * (temp-R);
			}
		
			// S까지의 횟수 구해서 빼기
			temp = (S / (R+A));
			result -= temp * D;
			
			temp = (S) % (R+A);
			if(temp - R > 0) {
				result -= ((double)D/A) * (temp-R);
			}			
		}
		
		bw.write(String.format(Locale.US, "%.12f\n", (result / ((E - S)))));
		bw.flush();
		bw.close();
		br.close();
	}
}