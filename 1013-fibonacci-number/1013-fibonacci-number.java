class Solution {
    // private int[] f;

    // private int fib_(int n) {
    //     if (n <= 1) return n;
    //     if (f[n] == 0) {
    //         f[n] = fib_(n - 1) + fib_(n - 2);
    //     }
    //     return f[n];
    // }

    public int fib(int n) {
        // f = new int[n + 1];
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}