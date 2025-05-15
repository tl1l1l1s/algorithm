import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 음이 아닌 정수 N
		// 수에서 한 쌍의 숫자를 골라 바꾸는 일을 하거나 한 하거나
		// 새 수 M, 맨 앞 줄에 0이 나타나면 안 된다
		// 행동 후의 최대/최소값
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String N = br.readLine();

			// 안 바뀌는 경우를 대비해 미리 N
			 int max = Integer.parseInt(N);
			 int min = Integer.parseInt(N);

			 char[] arr = N.toCharArray();
			 String current;
			 Character temp;
			 for(int i=0; i<arr.length; i++) {
				 for(int j=i+1; j<arr.length; j++) {
					 // 첫 자리 0 제외
					 if(i == 0 && arr[j] == '0') continue;

					 // exchange
					 temp = arr[i];
					 arr[i] = arr[j];
					 arr[j] = temp;
					 current = new String(arr);

					 max = Math.max(max, Integer.parseInt(current));
					 min = Math.min(min, Integer.parseInt(current));
				 
					 // rollback
					 arr[j] = arr[i];
					 arr[i] = temp;
				 }
			 }
			
			 bw.write("#" + tc + " " + min + " " + max + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}