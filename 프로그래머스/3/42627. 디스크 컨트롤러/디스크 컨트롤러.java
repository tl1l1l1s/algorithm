import java.util.*;
class Solution {
    
    class Task implements Comparable<Task> {
        int in;
        int takes;
        
        public Task(int in, int takes) {
            this.in = in;
            this.takes = takes;
        }
        
        @Override
        public int compareTo(Task o) {
            if(this.in == o.in) {
                return this.in - o.in;
            }
            
            return this.in - o.in;
        }
    }
    
    class Task2 implements Comparable<Task2> {
        int in;
        int takes;
        
        public Task2(int in, int takes) {
            this.in = in;
            this.takes = takes;
        }
        
        @Override
        public int compareTo(Task2 o) {
            if(this.takes == o.takes) {
                return this.in - o.in;
            }
            return this.takes - o.takes;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 대기 큐: 작업 번호, 요청 시각, 소요 시간 저장
        // 1. 우선순위가 제일 높은 작업 진행
            // 1. 소요시간 짧은 것
            // 2. 요청 시각이 빠른 것
            // 3. 작업 번호가 낮은 것
        // 2. 마칠 때까지 해당 작업만 수행
        PriorityQueue<Task> pq = new PriorityQueue<>();
        PriorityQueue<Task2> temp = new PriorityQueue<>(); // 여러 개가 동시에 실행 가능한 경우 사용할 pq
        
        for(int i=0; i<jobs.length; i++) {
            pq.add(new Task(jobs[i][0], jobs[i][1]));
        }
        
        int now = 0;
        
        while (!pq.isEmpty() || !temp.isEmpty()) {
            // now 시간보다 같거나 빠르게 들어온 것들 || pq.peek()의 도착 시간
                // poll 하고, peek 했을 때 now와 동일/작은 게 있으면 temp에 넣음
            if (temp.isEmpty() && !pq.isEmpty() && pq.peek().in > now) {
                now = pq.peek().in;
            }

            while (!pq.isEmpty() && pq.peek().in <= now) {
                Task t = pq.poll();
                temp.offer(new Task2(t.in, t.takes));
            }

            Task2 current = temp.poll();

            now += current.takes;
            answer += now - current.in;
        }
        
        return answer / jobs.length;
    }
}