public class FirstOccurrenceString {
    public static void main(String[] args) {
        System.out.println(firstOcc("sthbutsad", "sad"));
    }

    public static int firstOcc(String h, String n){
        if(h.length() < n.length()){
            return -1;
        }
        for(int i = 0; i <= h.length() - n.length(); i ++){
            int j = 0;
            while(j < n.length() && h.charAt(i+j) == n.charAt(j)){
                j++;
            }
            if(j==n.length()){
                return i;
            }
        }
        return -1;
    }
}
