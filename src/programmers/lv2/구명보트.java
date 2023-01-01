package programmers.lv2;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
//        int[] people = {70, 80, 50};
        int limit = 100;
//        int[] people = {10,20,30,40,50};
//        int limit = 50;
        int r = solution(people, limit);
        System.out.println(r);
    }
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int l = 0;
        int r = people.length - 1;
        while (true) {
            int sum = people[l] + people[r];
            if (sum <= limit) l++;
            r--;
            answer++;
            if (l > r) break;
        }
        return answer;
    }
}
