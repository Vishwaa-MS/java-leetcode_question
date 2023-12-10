import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0) {
                int diff = asteroids[i] + st.peek();
                if (diff < 0) {
                    st.pop();
                } else if (diff > 0) {
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    st.pop();
                }
            }
            if (asteroids[i] != 0) st.add(asteroids[i]);
        }
        int size = st.size();
        int i = size - 1;
        int[] ans = new int[size];
        while (!st.isEmpty()) {
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}
