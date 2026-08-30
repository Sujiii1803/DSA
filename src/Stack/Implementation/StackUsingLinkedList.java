package Stack.Implementation;

class Node {

    int data;
    Node next;

    Node(int data) {
       this.data = data;
       this.next = null;
    }
}
class StackList {

    private Node top;
    private int size;

    public StackList() {
        top = null;
        size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if( top == null ){
            System.out.println("Stack is Empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if( top == null ){
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
       return top == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.print("Stack Contents:");
        Node temp = top;
       while( temp != null ){
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
        System.out.println();
    }
}
public class StackUsingLinkedList {
    public static void main(String[] args) {

        StackList stack = new StackList();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();

        System.out.println("Peek Element "+stack.peek());

        System.out.println("Popped Element "+stack.pop());

        stack.display();

        System.out.println(stack.size());

        System.out.println(stack.isEmpty());
    }
}
