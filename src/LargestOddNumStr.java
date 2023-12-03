public class LargestOddNumStr {
    public static String largestOddNumber(String s) {

        int n = s.length();

        for(int i=n-1; i>=0; i--){
            int a = s.charAt(i);
            if(a%2!=0){
                return s.substring(0,i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "526";
        System.out.println(largestOddNumber(
                num
        ));
    }

}
