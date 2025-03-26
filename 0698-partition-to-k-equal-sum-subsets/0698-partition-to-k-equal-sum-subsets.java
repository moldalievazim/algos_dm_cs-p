class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
          sum += n;
        }

        if (sum % k != 0) {
          return false;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        
        return backtrack(nums, k, 0, 0, sum / k, used);
    }

    private boolean backtrack(int[]nums, int k, int currSum, int start, int target, boolean[] used) {
      if (k == 1) return true;

      if (currSum == target) return backtrack(nums, k - 1, 0, 0, target, used);

      for (int i = start; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
          continue;
        }

        used[i] = true;
        if (currSum + nums[i] <= target && backtrack(nums, k, currSum + nums[i], i + 1, target, used)) {
          return true;
        }
        used[i] = false;
      }
      return false;
    }
}