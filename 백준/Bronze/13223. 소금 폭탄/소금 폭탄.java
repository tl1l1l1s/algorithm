import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String currentTime = br.readLine();
		String saltTime = br.readLine();
		
		StringTokenizer sct = new StringTokenizer(currentTime);
		int currentHour = Integer.parseInt(sct.nextToken(":"));
		int currentMinute = Integer.parseInt(sct.nextToken(":"));
		int currentSecond = Integer.parseInt(sct.nextToken(":"));
		StringTokenizer sst = new StringTokenizer(saltTime);
		int saltHour = Integer.parseInt(sst.nextToken(":"));
		int saltMinute = Integer.parseInt(sst.nextToken(":"));
		int saltSecond = Integer.parseInt(sst.nextToken(":"));
		
		currentSecond = currentSecond + currentHour*3600 + currentMinute*60;
		saltSecond = saltSecond + saltHour*3600 + saltMinute*60;
		
		int seconds = saltSecond - currentSecond;
		if(seconds<=0) seconds += 24*3600;
		int hour = seconds/3600;
		int minute = (seconds-(hour*3600))/60;
		int second = (seconds-(hour*3600)-(minute*60));
		
		
//		String[] current = currentTime.split(":");
//		String[] salt = saltTime.split(":");
//		
//		for(int i=0; i<3; i++) {
//			if(Integer.parseInt(current[i])>Integer.parseInt(salt[i])) {
//				
//			}
		
		System.out.printf("%02d:%02d:%02d", hour, minute, second);
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
