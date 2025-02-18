class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            set.add(n);
        }

        int long_seq = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int seq_start = n;
                int seq_end = n;

                while (set.contains(seq_end + 1)) seq_end += 1;

                long_seq = Math.max(long_seq, seq_end - seq_start + 1);
            }
        }

        return long_seq;
    }
}