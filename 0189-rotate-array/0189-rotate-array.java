class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // reversing whole array
        reverse(nums, 0, nums.length - 1);
        // reversing first k elements
        reverse(nums, 0, k - 1);
        // reversing elements after k
        reverse(nums, k, nums.length - 1);
    }

        public void reverse(int[] nums, int start, int end) {
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }
        }
    
}