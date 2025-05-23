class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 겉 한 줄만 brown이어야 함
        // == 안쪽은 yellow...
        // 가로가 같거나 세로보다 길다
        
        // 가로 * 세로 = 값이어야 함
        // brown의 최소 세로 수는 3. 
        // 3으로 해서 나눠서 나누어떨어지는 값을 가로로 가지고
            // 3*3 일 때 세로-2 = 1 , 위에 가로-2 = 1 1*1 == yellow
        
        for(int row = 3; row<brown; row++) {
            
            int col = (brown - 2*(row-2)) / 2; 
            if((col - 2) * (row - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        return answer;
    }
}