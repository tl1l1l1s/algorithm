import java.io.*;
import java.util.*;

public class Main {
	
	static class D {
		String driver;
		long distance;
		
		D (String driver, long distance) {
			this.driver = driver;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 0 초과 1000 이하일 경우 트랙에서 DRS 사용 가능
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 드라이버 수
		int T = Integer.parseInt(st.nextToken()); // 트랙 한 바퀴 길이
		
		D[] drivers = new D[N]; // 드라이버 이름 / 앞 등수와의 거리 차(상대적)
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			drivers[i] = new D(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1; i<N; i++) {
			drivers[i].distance += drivers[i-1].distance;
			drivers[i].distance %= T;
		}
		
		// 정렬
		Arrays.sort(drivers, (a,b) -> Long.compare(a.distance, b.distance));
		
//		for(int i=0; i<drivers.length; i++) {
//			bw.write(drivers[i].driver + " " + drivers[i].distance + "\n");
//		}
		
		ArrayList<String> aD = new ArrayList<>();
		for(int i=0; i<drivers.length; i++) {
			// 0은 3과 비교
			// 1은 0과 비교
			
			long prev = drivers[(i-1 < 0 ? (drivers.length-1) : i-1)].distance;
			long curr = drivers[i].distance;
			
			long dst = (curr - prev + T) % T;
			
			if(dst > 0 && dst <= 1000) {
				aD.add(drivers[i].driver);
			}
		}
		
		Collections.sort(aD);
		
		if(aD.size() <= 0) {
			bw.write("-1");
		} else {
			for(int i=0; i<aD.size(); i++) {
				bw.write(aD.get(i) + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}