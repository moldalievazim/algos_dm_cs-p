class Solution {
    public int maximumGap(int[] nums) {
        for (int digit = 0; digit <= 9; digit++) {
            radixSort(nums, digit);
        }
        
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            answer = Math.max(answer, nums[i] - nums[i - 1]);
        }
        
        return answer;
    }

    public void radixSort(int[] nums, int digit) {
        int power = 1;
        for (int i = 1; i <= digit; i++) {
            power *= 10;
        }

        int[] count = new int[10];
        for (int num : nums) {
            int value = num / power % 10;
            count[value]++;
        }

        int[] prefixSum = new int[10];
        prefixSum[0] = count[0];
        for (int i = 1; i <= 9; i++) {
            prefixSum[i] = prefixSum[i - 1] + count[i];
        }

        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i] / power % 10;
            prefixSum[value]--;
            sorted[prefixSum[value]] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sorted[i];
        }
    }
}