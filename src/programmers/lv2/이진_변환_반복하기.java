package programmers.lv2;

import java.util.Arrays;

public class 이진_변환_반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";
//        String s = "0111010";
        int[] r = solution(s);
        System.out.println(Arrays.toString(r));
    }

    static int removedZeros = 0;
    static int callCount = 0;

    public static int[] solution(String s) {
        while (!s.equals("1")) s = toBinary(s);
        return new int[]{callCount, removedZeros};
    }

    static String toBinary(String s) {
        callCount++;
        removedZeros += s.chars().filter(c -> c == '0').count();
        return Integer.toBinaryString(
                s.replaceAll("0", "").length()
        );
    }
}
