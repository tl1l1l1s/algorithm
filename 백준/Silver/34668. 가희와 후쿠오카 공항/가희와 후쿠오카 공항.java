import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 06:00~00:00 국제선 -> 국내선 4분
		// 국내선 정차 2분
		// 국내선 -> 국제선 4분
		// 국제선 정차 2분
			// 막차 시간 지나면 운행 종료 아니면 1
		// 버스 1대, 50명
		int Q = Integer.parseInt(br.readLine());
		for(int q=0; q<Q; q++) {
			int M = Integer.parseInt(br.readLine()) + 1;
			
			// 출발 시각 (가희 기준) : 06:06
			// 한 바퀴 돌아오는데 : 12
			int cycle = (M / 50) - 1;
			if(M % 50 > 0) cycle++;

			int MM = 6 + (cycle*12);
			int HH = 6 + (MM / 60);
			MM %= 60;
			
			if(HH > 24 || (HH == 24 && MM > 6)) {
				bw.write("-1\n");
			} else {
				String rH = String.valueOf(HH);
				String rM = String.valueOf(MM);
				
				if(HH == 24) rH = "00";
				if(rH.length() == 1) rH = "0" + rH;
				if(rM.length() == 1) rM = "0" + rM;
				
				bw.write(rH + ":" + rM + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}