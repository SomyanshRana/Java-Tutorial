public class LinkedList_1 {

    // Static Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;
    static int size;

    // Add at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Add at any index
    public void add(int data, int idx) {

        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;

        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Delete first node
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val; 
    }

    //Delete last node
    public int removeLast() {
        if(size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0 ; i < size - 2 ; i++) {
            prev = prev.next;
        }
 
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val; 
    }

    //Iterartive Search
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    //Recursive Search
    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        } 

        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    //Reversing the Linked List
    public void Reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    } 

    //Delete ith index from last
    public void removeithFromLast(int n) {
        if(size == n) {
            head = head.next;
            return;
        }

        int i = 1;
        int idx = size - n;
        Node temp = head;
        while(i < idx) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        return;
    }

    // Middle node slow fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Check Palindrome
    public boolean Palindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        Node midNode = findMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        return true;
    }

    //Cyscle in Linked List
    public Boolean Cycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Remove the cycle
    public static void removeCyscle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    // Print the linked list
    public void print() {

        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Merge Sort in Linked List
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node MergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    //Zig Zag connect
    public void zigzag() {
        Node slow = head;
        Node fast = head.next;
         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right!= null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {

        LinkedList_1 ll = new LinkedList_1();

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.add(5, 2);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(4);
        ll.addLast(1);

        ll.print();

        ll.head = ll.MergeSort(ll.head);
        ll.print();

        // ll.Palindrome();
        // ll.removeFirst();
        // ll.removeLast();

        // ll.print();

        // System.out.println("Size = " + size);
    }
}