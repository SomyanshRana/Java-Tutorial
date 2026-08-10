import java.util.*;

public class Stack_JCL {
    public static void main(String args[]) {
        Stack<Integer> ob = new Stack<>();
        ob.push(1);
        ob.push(2);
        ob.push(3);

        while(!ob.isEmpty()) {
            System.out.println(ob.peek());
            ob.pop();
        }
    }
}
