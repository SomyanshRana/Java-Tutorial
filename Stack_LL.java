import java.util.LinkedList;
public class Stack_LL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = next;
        }
    }
    static class Stack {
        static Node head = null;

        public static Boolean isEmpty() {
           return head == null; 
        }

        public static void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }

            int top = head.data;
            return top;
        }
    }

    public static void main(String args[]) {
        Stack ob= new Stack();
        ob.push(1);
        ob.push(2);
        ob.push(3);

        while(!ob.isEmpty()) {
            System.out.println(ob.peek());
            ob.pop();
        }
    }
}
