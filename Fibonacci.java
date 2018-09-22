/**
  * @This helps to compute the Fibonacci number. BY LWJ 
  **/
public class Fibonacci {
    public static void main(String [] args) {
        int [] nums = new int[10];
        for (int i = 0; i < 5; i++) {
            nums[i] = (int)(Math.random() * 10 + 1);
        }
        System.out.println("Recursive version:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("The fibonacci number of %2d is %3d\n", nums[i], fibonacciRecursive(nums[i]));
        }
        System.out.println("Non-recursive version:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("The fibonacci number of %2d is %3d\n", nums[i], fibonacci(nums[i]));
        }
    }

    public static int fibonacci(int n) {
        int a = 1, b = 1, c = 1;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    

    public static int fibonacciRecursive(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
        
}