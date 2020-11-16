public class fizzbuzz {
    /**
     * This will be used during class as a collaborative coding exercise
     * "Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of
     * the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and
     * five print “FizzBuzz”."
     * @return
     */

    public static void print(String output) {
        System.out.println(output);
    }

    public static void fizzbuzz(int i) {
        if (((i % 3) == 0) && ((i % 5) == 0)) {  // % (Modulus) - Divides left-hand operand by right-hand operand and returns remainder.
            print("fizzbuzzInClass");
        } else if ((i % 3) == 0){
            print("fizz");
        } else if ((i % 5) == 0) {
            print("buzz");
        } else {
            print(new Integer(i).toString());
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            fizzbuzz(i);
        }
        //in class we'll write this code
    }
}
