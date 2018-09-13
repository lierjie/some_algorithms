/**
  * This class helps to judge whether an INT number is a palindrome.
  **/
public class IsPalindrome {
    public static void main(String [] args) {
        int [] testData = new int[10];
        for (int i = 0; i < 10; i++) {
            testData[i] = (int)(Math.random() * 1000);
        }
        System.out.println("Output of isPalindrone test:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Is the integer\t" + testData[i] + "\ta palindrome number?:" + isPalindrome(testData[i]));
        }
        System.out.println("Test is over!");
    }


    public static boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) { /* ones is 0(0 excluded) and negative number is not a palindrome.*/
            return false;
        }
        int res = 0;
        while (num > res) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return num == res || num == res / 10; /* even numbers and odd numbers are different */
    }
}