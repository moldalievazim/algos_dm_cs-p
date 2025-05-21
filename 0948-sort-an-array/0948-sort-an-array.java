class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] += 50000;
        }

        int k = 100000;
        int[] b = new int[n];
        int[] c = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }
        for (int j = 0; j < n; j++) {
            c[nums[j]]++;
        }
        for (int j = 1; j <= k; j++) {
            c[j] += c[j - 1];
        }
        for (int j = n - 1; j >= 0; j--) {
            b[c[nums[j]] - 1] = nums[j];
            c[nums[j]]--;
        }
        for (int i = 0; i < n; i++) {
            b[i] -= 50000;
        }

        return b;
    }
}