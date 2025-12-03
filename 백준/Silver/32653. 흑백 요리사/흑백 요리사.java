import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] steaks;
	
	static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        long g = gcd(a, b);

        return (a / g) * b;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 앞면과 뒷면을 한 번 이상 같은 횟수로 구울 것
		// 양면이 같은 시간으로 구워질 것
		// 두께 x, x분만큼 구운 뒤 반드시 뒤집을 것
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
		long l = 0L;

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            long value = 2L * x;

            if (i == 0) {
                l = value;
            } else {
                l = lcm(l, value);
            }
        }
		
		bw.write(l + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}