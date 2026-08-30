package Stack.Implementation;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }
}