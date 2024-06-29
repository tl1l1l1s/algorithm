import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numArray = new int[N];
		Set<Integer> numSet = new HashSet<Integer>();
		for(int i = 0; i<N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
			numSet.add(numArray[i]);
		}

		Integer[] nums = numSet.toArray(new Integer[numSet.size()]);
		Arrays.sort(nums);
        
		// indexOf의 시간복잡도가 O(n)이라 실패했었다! -> binarySearch() 사용할 것
		for(int i=0; i<numArray.length; i++) {
			bw.write(Arrays.binarySearch(nums, numArray[i]) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
