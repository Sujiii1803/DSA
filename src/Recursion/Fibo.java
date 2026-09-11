package Recursion;

public class Fibo {

    static int fib(int n) {

        // Base case
        if (n <= 1) {
            return n;
        }

        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int n = 6;

        System.out.println(fib(n));
    }
}
