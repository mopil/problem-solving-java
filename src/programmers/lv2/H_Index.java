package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

/**
 * 문제 이상 함
 */
public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int r = solution(citations);
        System.out.println(r);
    }

    public static int solution(int[] citations) {
        Integer[] temp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());
//        Integer[] indexList = new Integer[citations.length];
//        for (int i = 0 ; i< citations.length ; i++) {
//            indexList[i] = i+1;
//        }
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= i) {
                result = i;
                break;
            }
        }
        return result;
    }
}
