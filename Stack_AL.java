import java.util.ArrayList;

public class Stack_AL {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static Boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }

            int val = list.get(list.size() - 1);
            list.remove(list.size()-1);
            return val;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Stack ob = new Stack();

        ob.push(1);
        ob.push(2);
        ob.push(3);
        

        while(!ob.isEmpty()) {
            System.out.println(ob.peek());
            ob.pop();
        }

    }
}