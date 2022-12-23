package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int doneDays = (int) Math.ceil(remain / speeds[i]);
            days.add(doneDays);
        }
        System.out.println(days);
//        int i = 0;
//        while (i < days.size()) {
//            int count = 1;
//            for (int j = i + 1; j < days.size() - 1; j++) {
//                if (days.get(j) >= days.get(j + 1)) {
//                    count++;
//                    i++;
//                } else {
//                    i = j;
//                    break;
//                }
//            }
//            System.out.println(count);
//        }
        int[] answer = {};
        return answer;
    }

}
