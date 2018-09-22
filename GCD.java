/**
  * @This helps to compute the greatest common divisor of two integers. BY LWJ 
  **/
public class GCD {
    public static void main(String [] args) {
        int [] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (int)(Math.random() * 100 + 1);
        }
        for (int i = 0; i < 100;) {
            System.out.printf("The greatest common divisor of %4d and %4d is %4d\n", nums[i], nums[i + 1], gcd(nums[i], nums[i + 1]));
            i = i + 2;
        }
    }

    public static int gcd(int x, int y) {
        int temp;
        while (y > 0) {
            temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
        
}