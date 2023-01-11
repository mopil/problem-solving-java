package programmers.lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 숫자_게임 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
        int r = solution(A, B);
        System.out.println(r);
    }

    static PriorityQueue<Integer> getQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : arr) pq.add(n);
        return pq;
    }

    public static int solution(int[] A, int[] B) {
        PriorityQueue<Integer> aq = getQueue(A);
        PriorityQueue<Integer> bq = getQueue(B);
        int win = 0;
        for (int i = 0; i < A.length; i++) {
            int a = aq.poll();
            int b = bq.poll();
            if (a < b) win++;
            else bq.add(b);
        }
        return win;
    }

}
