import java.util.*;
public class Reverse_Stack {

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void pushtoBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushtoBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushtoBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
    for(int i = s.size() - 1; i >= 0; i--) {
        System.out.println(s.get(i));
    }
}
    public static void main(String args[]) {
        String str = "abc";
        String result = reverseString(str);
        System.out.println(result);

        Stack<Integer> ob = new Stack<>();
        ob.push(1);
        ob.push(2);
        ob.push(3);
        
        printStack(ob);
        System.out.println();
        reverseStack(ob);
        printStack(ob);
    }
}
