class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 1;
        int right = height.length - 2;

        int maxLeft = height[0];
        int maxRight = height[height.length - 1];

        int totalWater = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }

                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }
}