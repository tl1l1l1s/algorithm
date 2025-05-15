import java.util.*;

class Solution {
    static ArrayList<Integer> result;
    static boolean[] visited;
    
    static void sol(int[] cards, int n, int sum) {
        // n = 다음에 열어야 할 상자의 번호
        // sum = 현재 연 상자 수
        if(visited[cards[n]]) {
            result.add(sum);
            return;
        }
        
        visited[cards[n]] = true;
        sol(cards, cards[n], sum+1);
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        
        result = new ArrayList<Integer>();
        visited = new boolean[cards.length];
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
        }
        
        // 정한 숫자보다 같거나 작은 숫자 카드들
        // 카드의 수만큼 작은 상자를 준비
        
        // 준비된 상자에 카드를 한 장씩 넣고, 상자를 무작위로 섞어 일렬 정렬
        // 상자가 나열된 순서에 따라 1,2,...,
        
        // 임의 상자 선택, 숫자 카드 확인
        // 카드에 적힌 번호에 해당하는 상자를 열어...
        // 이미 열려있을 때까지 반복 => 1번 상자
        // 1번 상자 그룹 == totalLength(남는 게 없는 경우) => 0점
        
        // 나머지 2번 상자 그룹을 열어... 
        // 1번 상자 그룹의 수 * 2번 상자 그룹의 수  = 게임의 점수
        
        // 상자에 들어있는 카드번호가 순서대로 담긴 배열
        
        // visited[i] == false인 경우 돌려보고, 
        // 그룹별로 점수를 구하고, 제일 max인 것 두 개를 골라 곱한다.
        // 그룹이 한 개인경우 0을 출력, 2개인 경우 곱해서 제일 큰 것을 구한다
        
        for(int i=0; i<cards.length; i++) {
            cards[i] = cards[i]-1;
        }
        
        for(int i=0; i<cards.length; i++) {
            if(!visited[i]) {
                sol(cards, i, 0);
            }
        }
        
        if(result.size() != 1) {
            for(int i=0; i<result.size()-1; i++) {
                for(int j=i+1; j<result.size(); j++) {
                    answer = Math.max(answer, result.get(i) * result.get(j));
                }
            }
        }
        
        return answer;
    }
}