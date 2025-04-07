import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String binaryNumber = br.readLine();
		
		if(binaryNumber.length() % 3 == 1) {
			binaryNumber = "00" + binaryNumber;
		} else if(binaryNumber.length() % 3 == 2) {
			binaryNumber = "0" + binaryNumber;
		}
		
		for(int i=0; i<binaryNumber.length(); i+=3) {
			switch(binaryNumber.substring(i, i+3)) {
			case"000":
				bw.write("0");
				break;
			case"001":
				bw.write("1");
				break;
			case"010":
				bw.write("2");
				break;
			case"011":
				bw.write("3");
				break;
			case"100":
				bw.write("4");
				break;
			case"101":
				bw.write("5");
				break;
			case"110":
				bw.write("6");
				break;
			case"111":
				bw.write("7");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}