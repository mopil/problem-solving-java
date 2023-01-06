package programmers.lv2;

import java.util.Arrays;
import java.util.TreeSet;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String r = solution(s);
        System.out.println(r);
    }

    public static String solution(String s) {
        TreeSet<Integer> sort = new TreeSet<>();
        Arrays.stream(s.split(" ")).forEach(it -> sort.add(Integer.parseInt(it)));
        return sort.first() + " " + sort.last();
    }
}
