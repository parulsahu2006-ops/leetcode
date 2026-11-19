class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long num = 0;

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // 3. Convert digits and handle overflow
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');

            if (sign * num <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }
}