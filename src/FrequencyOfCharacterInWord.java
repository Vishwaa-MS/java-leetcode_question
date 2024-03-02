import java.util.HashMap;
import java.util.Map;

public class FrequencyOfCharacterInWord {


    public boolean frequency(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        int n = words.length;
        for (Character chr : map.keySet()) {
            int val = map.get(chr);
            if (val % n != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean freq(String[] words) {
        int[] count = new int[26];
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
        }

        int n = words.length;
        for (int val : count) {
            if (val % n != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
