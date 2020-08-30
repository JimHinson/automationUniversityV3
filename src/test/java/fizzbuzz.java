public class fizzbuzz {
    /**
     * This will be used during class as a collaborative coding exercise
     * "Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of
     * the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and
     * five print “FizzBuzz”."
     * @return
     */

    public static boolean palindrome(String toTest) {

        return true;
    }

    public static void print(String output) {
        System.out.println(output);
    }

    public static void fizzbuzz(int i) {
        if ((i % 3) == 0){
            print("fizz");
        } else if ((i % 5) == 0) {
            print("buzz");
        } else {
            print(new Integer(i).toString());
        }
//        return true;
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            fizzbuzz(i);
        }
        System.out.println("Is Palindrome:\n"
                + "fizzbuzz: " + new Boolean(palindrome("fizzbuzz")).toString()
        );
        //in class we'll write this code
    }
}
