class Solution {
    public double myPow(double x, int n) {
        long exponent = (long) n;

        //  negative n, x^n    = (1/x)^(-n)
        //          -7, x^(-7) = (1/x)^7
        if (exponent < 0) {
            exponent = -exponent;
            x = 1 / x;
        }
        return myPow_(x, exponent);
    }

    private double myPow_(double x, long exponent) {
        if (exponent == 0) return 1;

        // even n, x^n = (x^2)^(n/2) = x^(2*(n/2))
        //         x^6 = (x^2)^3 = x^(2*3)

        // odd n,  x^n = (x^2)^(n/2)*x = x^(2*(n/2))*x = x^(n-1)*x
        //         x^7 = (x^2)^3 * x = x^(2*3) * x = x^6 * x

        return (exponent % 2 == 0) ? myPow_(x * x, exponent / 2) : myPow_(x * x, exponent / 2) * x; 
    }
}