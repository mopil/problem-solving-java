package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 가장_가까운_같은_글자 {
    public static void main(String[] args) {
        solution("foobar");
    }

    public static List<Integer> solution(String s) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char curChar = chars[i];
            int count = 0;
            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                count++;
                if (chars[j] == curChar) {
                    flag = true;
                    break;
                }
            }
            if (count == 0 || !flag) count = -1;
            result.add(count);
        }
        return result;
    }
}
