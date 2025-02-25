class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0; 
        int answer = -1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int need = 1;
            int cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = w;
                } else {
                    cur += w;
                }
            }

            if (need > days) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}