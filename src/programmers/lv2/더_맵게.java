package programmers.lv2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] args) {
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int k = 7;
        int[] scoville = {1,1,200};
        int k = 100;
        int r = solution(scoville, k);
        System.out.println(r);
    }

    public static int solution(int[] scoville, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : scoville) heap.add(n);
        int count = 0;
        while (heap.peek() < k) {
            if (heap.size() >= 2) {
                int smallest = heap.poll();
                int smaller = heap.poll();
                int newScoville = smallest + smaller * 2;
                heap.add(newScoville);
                count++;
            } else return -1;
        }
        return count;
    }
}
