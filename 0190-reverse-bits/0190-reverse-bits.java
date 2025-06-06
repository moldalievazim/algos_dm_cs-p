public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
          int bit = (n >> i) & 1;
          if (bit == 1) {
            result |= 1 << (31 - i);
          }
        }
        return result;
    }
}