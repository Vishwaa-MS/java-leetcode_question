import java.util.Scanner;
import java.util.Stack;

public class RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        if (k >= n) return "0";

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() > num.charAt(i) && k != 0) {
                st.pop();
                k--;
            }
            if (!st.isEmpty() || num.charAt(i) != '0') {
                st.push(num.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        System.gc();
        return str.reverse().toString();
    }

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        int digits = num.length() - k;

        char[] stack = num.toCharArray();
        int top = -1;
        int start = 0; // for trailing zeros

        for (int i = 0; i < stack.length; i++) {
            while (k > 0 && top >= 0 && stack[top] > stack[i]) {
                top--;
                k--;
            }
            top++;
            stack[top] = stack[i];
        }

        while (start <= top && stack[start] == '0') {
            start++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = start; i < digits; i++) {
            result.append(stack[i]);
        }

        if (result.isEmpty()) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
    }
}
