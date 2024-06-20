public class CountAndSay {
    public static void main(String[] args) {
//        System.out.println(CountSay(5));
        System.out.println("flow".substring(2));
    }


    public static String CountSay(int n){
        if(n==1) return "1";
        String str = CountSay(n-1);
        StringBuilder Ans = new StringBuilder();
        String ans = count(str);
        return ans;
    }

    public static String count(String str){
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(count);
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
