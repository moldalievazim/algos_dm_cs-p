class Solution {
    public int subarraySum(int[] nums, int k) {
        int currPrefixSum = 0;
        int answer = 0;

        Map<Integer, Integer> prefixSumSeenCount = new HashMap<>();

        prefixSumSeenCount.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currPrefixSum += nums[i];
            answer += prefixSumSeenCount.getOrDefault(currPrefixSum - k, 0);
            prefixSumSeenCount.put(currPrefixSum, prefixSumSeenCount.getOrDefault(currPrefixSum, 0) + 1);
        }

        return answer;
    }
}