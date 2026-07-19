class Solution {
    public int solution(int num) {
        long n = num;
        int answer = 0;
        
        while(n != 1 && answer < 500) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            
            answer++;
        }
        
        System.out.println(num);
        return answer == 500 ? -1 : answer;
    }
}