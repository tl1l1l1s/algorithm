import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문제를 많이 푼 팀
		// 동일 수의 문제 = 페널티 합이 적은 순
		// N등을 한 팀이 푼 문제 수, 문제 번호
		String[][] board = {{"11", "A B C D E F G H J L M"},
                {"9", "A C E F G H I L M"},
                {"9", "A C E F G H I L M"},
                {"9", "A B C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A B C F G H L M"}};
		int N = Integer.parseInt(br.readLine());
		
		bw.write(board[N-1][0] + "\n" + board[N-1][1] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}