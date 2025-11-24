import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine();
		String[] nums = st.split("\\+");

	
		if(nums.length == 2 && 
				(nums[0].length() >= 1 &&
				nums[0].charAt(0) - '0' > 0 && nums[0].charAt(0) - '0' <= 9)
				&& (nums[1].length() >= 1 &&
						nums[1].charAt(0) - '0' > 0 && nums[1].charAt(0) - '0' <= 9)
				&& nums[0].equals(nums[1])) {
			bw.write("CUTE");
		} else {
			bw.write("No Money");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}