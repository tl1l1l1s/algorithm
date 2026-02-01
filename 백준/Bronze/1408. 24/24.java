import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 시작한 시간까지 앞으로 몇 시간 남았는지
		String[] now = br.readLine().split(":");
		String[] start = br.readLine().split(":");
		
		int rH = 0;
		int rM = 0;
		int rS = 0;
		
		rS = Integer.parseInt(start[2]) - Integer.parseInt(now[2]);
		if(rS < 0) {
			rM -= 1;
			rS += 60;
		}
		
		rM += Integer.parseInt(start[1]) - Integer.parseInt(now[1]);
		if(rM < 0) {
			rH -= 1;
			rM += 60;
		}
		
		rH += Integer.parseInt(start[0]) - Integer.parseInt(now[0]);
		if(rH < 0) {
			rH += 24;
		}
		
		bw.write(String.format("%02d:%02d:%02d", rH, rM, rS) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}