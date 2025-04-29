class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || 
            nums2.length > nums1.length * 6) {
                return -1;
            }

        int sum1 = 0;
        int sum2 = 0;
        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;

        if (sum1 == sum2) return 0;

        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums1) minHeap.offer(x);
        for (int x : nums2) maxHeap.offer(x);

        int operations = 0;
        for (; sum1 < sum2; operations++) {
            if (maxHeap.isEmpty() || maxHeap.peek() - 1 < 6 - minHeap.peek()) {
                sum1 += 6 - minHeap.poll();
            } else {
                sum2 -= maxHeap.poll() - 1;
            }
        }
        return operations;
    }
}