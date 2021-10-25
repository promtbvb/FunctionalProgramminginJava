package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes 1 arg and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFun.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Fun.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneAndThenMultiplyBy10 =
                incrementByOneFun.andThen(multiplyBy10Fun);
        System.out.println(addByOneAndThenMultiplyBy10.apply(4));

        //BiFunction takes 2 args and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyBiFun.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFun =
            number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Fun =
            number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFun =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}


