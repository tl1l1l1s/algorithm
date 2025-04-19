import java.util.*;

class Solution {
    static HashSet<Integer> set;
    static int max;
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        max = 0;
        
        // 이미 체크한 수인지를 확인하기 위해 isVisited 배열 사용
        boolean[] visited = new boolean[numbers.length()];
        Arrays.fill(visited, false);
        
        permutation(numbers, "", visited); // 순열 함수를 사용하여 set에 가능한 수를 모두 추가
        
        // 에라토스테네스의 체를 사용하여 소수 체크
        Boolean[] isPrime = new Boolean[max+1];
        Arrays.fill(isPrime, true); // 초기화
        
        for(int i=2; i<Math.sqrt(isPrime.length)+1; i++) {
            if(isPrime[i] == false) { // 이미 false인 경우 continue
                continue;
            }
            
            for(int j=2; j*i<isPrime.length; j++) {
                isPrime[j*i] = false; // i*j는 전부 false 처리, 이후 true로 남은 것들만이 소수에 해당
            }
        }
        
        for(int i : set) {
            if(i < 2) {
                continue;
            }
            
            if(isPrime[i] == true) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void permutation(String numbers, String current, boolean[] visited) {
        if(!current.isEmpty()) {
            set.add(Integer.parseInt(current));
            max = Math.max(max, Integer.parseInt(current));
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(numbers, current + numbers.charAt(i), visited);
                visited[i] =false;
            }
        }
    }
}