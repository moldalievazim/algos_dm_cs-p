class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            bestSum = Math.max(bestSum, currSum);

            if (currSum < 0) currSum = 0;
        }
        
        return bestSum;
    }
}