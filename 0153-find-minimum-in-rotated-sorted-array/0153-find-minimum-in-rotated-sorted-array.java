class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (nums == null || n == 0) return 0;
        if (n == 1) return nums[0];

        // Array was rotated n times -> same as not rotated
        if (nums[0] < nums[n - 1]) return nums[0];

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}