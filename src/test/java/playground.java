import java.util.*;

/*
TAU 100
she's declaring class variables that are used in methods without being passed in
 */
public class playground {

    public void collections() {
        //set: can't contain dups
        //list: ordered elements accessible by position, can contain dups
        //queue: FIFO
        //map: unordered unique key-value pairs:
        //  account - amount
        //  account - amount
        //map
        //  putIfAbsent()
        var unchangeableList = List.of("apple", "orange"); //this is immutable

        var something = unchangeableList.iterator();
        while (something.hasNext()) {
            System.out.println("another: " + something.next());
        }
        for (var another : unchangeableList);
        //<> - specify the type of objects in a list
        //lambda:
        unchangeableList.forEach(x -> System.out.println(x));
        unchangeableList.forEach(System.out::println);
        //map<string, Integer>

        //pop quiz
        //makeup exam
        //given two maps of test scores, update the grade if they did better on the second
        Map grades = new HashMap();
        grades.put("ben", 22);
        grades.put("abs", 23);
        grades.put("geg", 24);

        Map makeups = new HashMap();
        makeups.put("abs", 245);
        makeups.put("geg", 222);

//        grades.forEach(x -> bigger(grades, makeups));

    }

    public int bigger(int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static void setDemo() {
        Set<String> fruit = new HashSet();
        fruit.add("apple");
        fruit.add("lemon");
        fruit.add("banana");
        fruit.add("orange");
        fruit.add("lemon");
//        System.out.println(fruit.size());
//        System.out.println(fruit);

        var i = fruit.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        for(String item: fruit) {
            System.out.println(item);
        }
        fruit.forEach(x -> System.out.println(x)); //lambda expression
        fruit.forEach(System.out::println); //does same as above
    }

    private static void mapDemo() {
        Map<String, Integer> fruitCalories = new HashMap();
        fruitCalories.put("apple", 95);
//        fruitCalories.forEach();

        for (var entry: fruitCalories.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void stuff() {
        System.out.println("don't do much");
        String[] myRay = {"1", "ad", "be", "cf"};
        for (var i = 0; i < myRay.length; i++) {
            System.out.println("myRay[" + i + "]: " + myRay[i]);
        }
        for (var ray: myRay) {
            System.out.println("myRay:" + ray);
            System.out.println("shortcut: " + new Integer(ray).toString());
        }
    }

    private static void days() {
        //Strings are immutable; use StringBuilder
        Scanner in = new Scanner(System.in);
        System.out.print("What day?");
        int s = Integer.parseInt(in.nextLine());
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println("what day? " + s);
        System.out.println(weekdays[s]);
        int highest = 0;
    }


    public static Map getOriginalGrades() {
        Map<String, Integer> grades = new HashMap();
        grades.put("Angie", 24);
        grades.put("Dave", 55);
        return grades;
    }

    public static Map getMakeUpGrades() {
        Map<String, Integer> grades = new HashMap();
        grades.put("Angie", 97);
        grades.put("Dave", 82);
        return grades;
    }

    public static void main(String[] args) {
        Map<String, Integer> finalGrades = new HashMap();
        Map<String, Integer> firstGrade = getOriginalGrades();
        Map<String, Integer> makeupGrade = getMakeUpGrades();
//        firstGrade.forEach(finalGrades::put(firstGrade.)));
//        finalGrades.put()
        for (var entry: firstGrade.entrySet()) {
            Integer greaterGrade = (firstGrade.get(entry) > makeupGrade.get(entry)) ? firstGrade.get(entry) : finalGrades.get(entry);
            finalGrades.put(entry.getKey(), greaterGrade);
        };
        System.out.println(finalGrades);

    }

//    private int[] searchArr(int[] input) {
//        Arrays.sort(input);
////        Arrays.binarySearch();
//        for (int value : input) {
//
//        }
//    }
}
