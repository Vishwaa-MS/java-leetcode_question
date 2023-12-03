public class Fibonacci {

    public int fib(int n) {
        int num1 =0 ; int num2 = 1; int num3=0;
        int count = 0;
        while(count<n){
            num3 = num2+num1;
            num1=num2;
            num2=num3;
            count+=1;
        }
        return num3;
    }
}
