import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int S;
    static int[] nums;
    
    // 부분합을 저장하는 메소드
    static void solution(int start, int end, int idx, int sum, List<Integer> list) {
        if(idx == end) {
            list.add(sum);
            return;
        }
        
        // 현재 원소를 선택하지 않는 경우
        solution(start, end, idx + 1, sum, list);
        // 현재 원소를 선택하는 경우
        solution(start, end, idx + 1, sum + nums[idx], list);
    }
    
    // 타겟 이상의 값이 처음 나오는 위치
    static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }
    
    // 타겟 초과 값이 처음 나오는 위치
    static int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > target) right = mid;
            else left = mid + 1;
        }
        return right;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N개의 정수로 이루어진 수열
        // 크기가 양수인 부분수열 중 원소를 다 더한 값이 S가 되는 경우의 수
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열을 반으로 나누어 부분수열을 탐색하는 방식으로 시간초과가 나지 않게끔 구현
        int mid = N/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        solution(0, mid, 0, 0, left);
        solution(mid, N, mid, 0, right);
        
        Collections.sort(right);
        long count = 0;
        
        // S가 되는 경우의 수 계산
        for(int sum : left) {
            int target = S - sum;
            int low = lowerBound(right, target);
            int high = upperBound(right, target);
            count += (high - low);
        }
        
        // 공집합 + 공집합 = 0 케이스 제거 (S=0인 경우)
        if(S == 0) {
            count--; // 양쪽 모두 공집합인 경우 제외
        }
        
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}