package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


    /**
     * operation : x -> ((x * 2) + 3) ^ 5
     */

    private static Double getOperation(Integer x)
    {
        Double operation = Double.valueOf(((x * 2) + 3));
        Double res = 1.0;

        for (int i = 0; i < 5; i++)
        {
            res *= operation;
        }

        return res;
    }

    public static List<Double> compute1(List<Integer> input) {

        List<Double> compute = new ArrayList<>();

        for (Integer i : input)
        {
            compute.add(getOperation(i));
        }

        return compute;
    }

    public static String operationString(String input)
    {
        if (input.equals("") || input.length() == 0)
            return input;
        StringBuilder buildRes = new StringBuilder();
        String firstLetter = input.substring(0, 1).toUpperCase();
        String otherLetters = input.substring(1);
        String wordResult = new StringBuilder().append(firstLetter).append(otherLetters).toString();
        buildRes.append(wordResult).append(wordResult);

        String res = buildRes.toString();

        return res;
    }

    /**
     * operation : abc -> AbcAbc
     */
    public static List<String> compute2(List<String> input) {
        List<String> compute2 = new ArrayList<>();

        for (String s : input)
        {
            compute2.add(operationString(s));
        }
        return compute2;
    }

}
