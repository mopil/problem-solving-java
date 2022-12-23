package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1, 3, 2, 4, 2};
        solution(answers);
    }

    public static List<Integer> solution(int[] answers) {
        int[] answer = new int[3];
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) count++;
        }
        answer[0] = count;

        count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (two[i % two.length] == answers[i]) count++;
        }
        answer[1] = count;

        count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (three[i % three.length] == answers[i]) count++;
        }
        answer[2] = count;

        int max = 0;
        for (int n : answer) max = Math.max(max, n);
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) r.add(i+1);
        }
        return r;
    }
}
