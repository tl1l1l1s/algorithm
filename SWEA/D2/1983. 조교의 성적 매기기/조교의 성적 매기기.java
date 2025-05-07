import java.util.*;
import java.io.*;

class Solution
{
	static final String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	
	static class Student implements Comparable<Student> {
		int no;
		double totalGrade;
		double midterm;
		double finalterm;
		double assignment;
		
		Student(int no, int m, int f, int a) {
			this.no = no;
			this.midterm = m;
			this.finalterm = f;
			this.assignment = a;
			this.totalGrade = (this.midterm * 0.35) + 
					(this.finalterm * 0.45) + (this.assignment * .2);
		}
		
		@Override
		public int compareTo(Student o) {
			return Double.compare(o.totalGrade, this.totalGrade);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Student> list = new ArrayList<>();
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Student(
						i,
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
					));
			}
			
			Collections.sort(list);
			// 한 학점당 N/10명씩 넣을 수 있다
			int gradeIdx = 0;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).no == K) {
					gradeIdx = i / (N/10);
					break;
				}
			}
			bw.write("#" + tc + " " + grade[gradeIdx] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}