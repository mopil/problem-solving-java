package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 유용한표현들 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // Integer[] -> List<Integer> (배열 -> 리스트)
        Integer[] integers = new Integer[3];
        List<Integer> list1 = Arrays.asList(integers);

        // int[] -> List<Integer> (배열 -> 리스트, 박싱)
        int[] ints = new int[3];
        List<Integer> list2 = Arrays.stream(ints).boxed().collect(Collectors.toList());

        // List<Integer> -> Integer[] (리스트 -> 배열)
        Integer[] ints1 = list.toArray(new Integer[3]);

        // List<Integer> -> int[] (리스트 -> 배열, 언박싱)
        int[] ints3 = list.stream().mapToInt(i -> i).toArray();
        int[] ints4 = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
