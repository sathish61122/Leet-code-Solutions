class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Deter
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        // Subtract divisor using powers of 2
        while (a >= b) {
            long temp = b;
            long multiple = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        // Apply sign
        if (negative) {
            quotient = -quotient;
        }

        // 32-bit integer range protection
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}
