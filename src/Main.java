import java.util.Arrays;

class main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 2, 2};
        MajorityElements m = new MajorityElements();
        System.out.println(m.majorityElement(arr));

//        int[] arr = new int[]{1,3,5,2,2,5,5,6,4,5,7,5,9};
//        RemoveDuplicateArray r = new RemoveDuplicateArray();
//        System.out.println(consecutiveOnes(arr));
//        NoOfChar ch = new NoOfChar();
//        String str = "Vishwaav Mmi s";
//        ch.noOfChar(str);
//       boolean s =  main.isPalindrome(" M O M 6");
//       System.out.println(s);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;

        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static int consecutiveOnes(int[] nums) {

        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }
}