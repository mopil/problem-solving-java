package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        List<String> r = solution(n ,arr1, arr2);
        System.out.println(r);
    }

    static String toBinary(int n, int num) {
        String b = Integer.toBinaryString(num);
        while (b.length() < n) b = "0" + b;
        return b;
    }

    public static List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i< arr1.length ; i++) {
            String b1 = toBinary(n, arr1[i]);
            String b2 = toBinary(n, arr2[i]);
            System.out.println(b1);
            System.out.println(b2);
            String line = "";
            for (int j = 0 ; j < b1.length() ; j++) {
                if (b1.charAt(j) == '0' && b2.charAt(j) == '0') line += " ";
                else line += "#";
            }
            result.add(line);
        }
        return result;
    }
}
