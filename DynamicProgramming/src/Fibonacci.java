public class Fibonacci {

    public static void main(String[] args) {
        int n = 20; // Example input
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));

        System.out.println("Number of calls: " + counter);

        System.out.println("Fibonacci of " + n + " is: " + fibonacciMemoized(n));
        System.out.println("Number of calls with memoization: " + counter2);
    }

    static int counter = 0;

    public static int fibonacci(int n) {
        counter++;
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int counter2 = 0;
    public static int fibonacciMemoized(int n) {

        int fibList[] = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibList[i] = fibList[i - 1] + fibList[i - 2];

            counter2++;

        }
        return fibList[n];
    }
}