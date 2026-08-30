package Stack.Implementation;

class StackArray {

    private int[] arr;
    private int top;

    public StackArray(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int value) {

        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        arr[++top] = value;
    }

    public int pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return arr[top--];
    }

    public int peek() {

        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        System.out.println("Stack Contents:");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackUsingArray {

    public static void main(String[] args) {

        StackArray st = new StackArray(5);

        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Top element: " + st.peek());

        System.out.println("Popped element: " + st.pop());
        st.display();

        System.out.println("Top element after pop: " + st.peek());
        st.display();

        System.out.println("Stack size: " + st.size());

        System.out.println("Is stack empty? " + st.isEmpty());

        st.pop();
        st.pop();

        System.out.println("Is stack empty after removing all elements? " + st.isEmpty());
    }
}