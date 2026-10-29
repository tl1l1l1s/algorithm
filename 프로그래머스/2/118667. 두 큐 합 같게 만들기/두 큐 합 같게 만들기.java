class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n1 = queue1.length;
        int len = n1 + queue2.length;

        long leftSum = 0, total = 0;
        for (int q : queue1) leftSum += q;
        total = leftSum;
        for (int q : queue2) total += q;

        if (total % 2 != 0) return -1;
        long mid = total / 2;

        int l = 0, r = n1, count = 0;
        int limit = len * 2;

        while (count <= limit) {
            if (leftSum == mid) return count;

            if (leftSum < mid) {
                leftSum += (r < n1) ? queue1[r] : queue2[r - n1];
                r = (r + 1) % len;
            } else {
                leftSum -= (l < n1) ? queue1[l] : queue2[l - n1];
                l = (l + 1) % len;
            }
            count++;
        }
        return -1;
    }
}