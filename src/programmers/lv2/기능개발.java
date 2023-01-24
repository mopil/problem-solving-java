package programmers.lv2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        List<Integer> r = solution(progresses, speeds);
        System.out.println(r);
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int doneDays = (int) Math.ceil((double) remain / speeds[i]);
            days.add(doneDays);
        }
        // 이전 작업 끝나는 시각 vs. 내 작업 끝나는 시각
        int finish = days.get(0);
        List<Integer> copy = new ArrayList<>(days);
        for (int i = 1 ; i<days.size(); i++) {
            if (finish >= days.get(i)) {
                copy.remove(i);
                copy.add(i, finish);
            }
            else finish = days.get(i);
        }
        System.out.println("남은 날 수 " + days);
        System.out.println("계산된 날 수 " + copy);

        Set<Integer> keys = new TreeSet<>(copy);
        List<Integer> result = new ArrayList<>();
        for (int key : keys) {
            long count = copy.stream().filter(it -> it.equals(key)).count();
            result.add((int) count);
        }
        return result;
    }

}
