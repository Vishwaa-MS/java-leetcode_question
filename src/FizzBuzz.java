import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n){
        List<String> arrL = new ArrayList<>();
        for(int i =1; i<=n; i++){
            if(i%3==0 && i%5==0){
                arrL.add("FizzBuzz");
            } else if (i%3==0) {
                arrL.add("Fizz");
            } else if (i%5==0) {
                arrL.add("Buzz");
            }
            else {
                arrL.add(Integer.toString(i));
            }
        }
        return arrL;
    }



    public static void main(String[] args) {
        System.out.println(fizzBuzz(20));
    }
}
