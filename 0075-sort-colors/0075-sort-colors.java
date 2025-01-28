class Solution {
    public void sortColors(int[] nums) {
        // position to insert zero
        int zeroInsertPos = 0;

        // position to insert two
        int twoInsertPos = nums.length - 1;

        // iterator
        int i = 0;

        // loop to check the number and put it in its position respectively(0, 1, 2)
        while(i <= twoInsertPos) {
            if (nums[i] == 0) {
                swap(nums, zeroInsertPos, i);
                zeroInsertPos++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, twoInsertPos);
                twoInsertPos--;
            }
        }
    }

    // helper function to swap(sort) the positions of numbers
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}