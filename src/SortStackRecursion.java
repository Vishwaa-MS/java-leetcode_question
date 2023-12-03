import java.util.Stack;

public class SortStackRecursion {

    public static void sortStack(Stack<Integer> stack) {
        // write your code here
        //Lets Apply B H I Method :::

        //Base Case ::: 
        if(stack.isEmpty()){
            return;
        }
        //Hypothesis::
        int lastElement =stack.pop();
        //Induction:::
        sortStack(stack);
        insertStack(stack,lastElement);

    }
    public static void insertStack(Stack<Integer> stack,int temp){
        ///Base Case :::
        if(stack.size()==0 || stack.peek()<=temp){
            stack.push(temp);
            return; 
        }
        //Hypothesis
        int lastElement =stack.pop();
        //Induction
        insertStack(stack,temp);
        stack.push(lastElement);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        sortStack(st);
        System.out.println(st);

    }

}