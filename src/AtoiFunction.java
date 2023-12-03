class AtoiFunction {
    public int myAtoi(String str) {
        int length = str.length();

        if (length == 0) {
            return 0;
        }

        int index = 0;

        while (index < length && str.charAt(index) == ' ') {
            ++index;
        }

        if (index == length) return 0;

        boolean isNegative = false;

        if (index < length) {
            if (str.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (str.charAt(index) == '+') {
                isNegative = false;
                ++index;
            }
        }

        int result = 0;

        while (index < length && isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';

            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;

            ++index;
        }
        return isNegative ? -result : result;
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

}