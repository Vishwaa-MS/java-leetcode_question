import java.util.Arrays;

public class ReverseWordsInString {

    public static String reverseWords(String str){
        String[] temp = str.split(" ");
        System.out.println(Arrays.toString(temp));
        StringBuilder newString = new StringBuilder();
        for(String s : temp){
            String tempStr = "";
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                tempStr = ch + tempStr;
            }
            newString.append(tempStr).append(" ");
        }
        return String.valueOf(newString).trim();
    }

    public static void main(String[] args) {
        String temp = reverseWords("Hi This Is Vishwaa's");
        System.out.println(temp);
    }
}
