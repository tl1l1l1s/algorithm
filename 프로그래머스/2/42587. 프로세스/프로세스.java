import java.util.*;
class Solution {
    static class Node {
        int index;
        int priority;
        
        Node(int n, int p) {
            this.index = n;
            this.priority = p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // priorities = 중요도가 순서대로 담긴 배열
        // 몇 번째로 실행되는지 알고 싶은 프로세스의 위치를 알려주는 location
        Queue<Node> q = new ArrayDeque<Node>();
        for(int i=0; i<priorities.length; i++) {
            q.add(new Node(i, priorities[i]));
        }

        while(!q.isEmpty()) {
            boolean flag = false;
            Node current = q.poll();
            
            for(int i=9; i>current.priority; i--) {

                for(Node n : q) {
                    if(n.priority == i) {
                        flag = true;
                        break;
                    }
                }
            }
            
            if(flag) {
                q.offer(current);
            } else {
                answer++;
                if(current.index == location) break;
            }
        }
        
        return answer;
    }
}