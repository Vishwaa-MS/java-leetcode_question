public class PlindromeNumber {

    public static void main(String[] args) {
        System.out.print(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        int t=x;
        int reverse = 0;
        while (x > 0) {
            int n = x % 10;
            reverse = reverse * 10 + n;
            x=x/10;
        }
        if(t==reverse)return true;
        else return false;
    }
}
