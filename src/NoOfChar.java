import java.util.HashMap;
public class NoOfChar {

    public void noOfChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        int n = str.length();
        str = str.toLowerCase();

        for (int i = 0; i < n; i++) {
            Character chr = str.charAt(i);
            if(Character.isLetter(chr)){
                if (map.containsKey(chr)) {
                    map.put(str.charAt(i), map.get(chr) + 1);
                } else {
                    map.put(chr, 1);
                }
            }
        }
        System.out.println(map.entrySet());
    }
}
