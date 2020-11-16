/**
 * This will be used during class as a collaborative coding exercise
 * "Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of
 * the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and
 * five print “FizzBuzz”."
 * @return
 */

public class fizzbuzzInClass {

    //loop 1 - 100
    //check for multiples of 5 and 3 ->
    //check for 3
    //check for multiples of 5
    //print


    public static void print(String output) {
        System.out.println(output);
    }

    public static void main (String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (((i % 5) == 0) && (i % 3) ==0) {
                print("FizzBuzz");
            } else if ((i % 3) ==0 ) {
                System.out.println("Fizz");
            } else if ((i % 5) == 0 ) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }


}
