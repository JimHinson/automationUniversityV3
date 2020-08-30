public class palindrome {
    /**
     * Determine whether the input is a palindrome, e.g. a word which is the same forward and backward
     */
    public static void palindrome(String testMe) {
//        Array testable = testMe.
        for (int i = 0; i < (testMe.length() / 2); i++) {
            if (testMe.charAt(i) == testMe.charAt(testMe.length() - (i + 1)))  {
//                do nothing
            } else {
                System.out.println(testMe + " is not a palindrome");
                return;
            }
            System.out.println(testMe + " is a palindrome");
        }
    }

    public static void main(String[] args) {
        palindrome("Mom");
        palindrome("mome");
        palindrome("mom");
    }
}
