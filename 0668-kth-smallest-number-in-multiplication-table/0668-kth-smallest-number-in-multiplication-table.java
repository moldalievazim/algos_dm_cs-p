class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countNumsLessThanOrEqualToValueInMultTableMbyN(mid, m, n);
            if (count >= k) {
                answer = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private int countNumsLessThanOrEqualToValueInMultTableMbyN(int value, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(value / i, n);
        }

        return count;
    }
}