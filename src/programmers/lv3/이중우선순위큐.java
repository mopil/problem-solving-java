package programmers.lv3;

import java.util.Arrays;
import java.util.TreeSet;

public class 이중우선순위큐 {
    public static void main(String[] args) {
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] r = solution(operations);
        System.out.println(Arrays.toString(r));
    }

    public static int[] solution(String[] operations) {
        TreeSet<Integer> heap = new TreeSet<>();

        for(String op : operations) {
            String[] token = op.split(" ");
            String cmd = token[0];
            String value = token[1];
            if (cmd.equals("I")) {
                heap.add(Integer.parseInt(value));
            } else if (cmd.equals("D")) {
                if (!heap.isEmpty()) {
                    if (value.equals("1")) heap.remove(heap.last());
                    else heap.remove(heap.first());
                }
            }
        }
        if (heap.isEmpty()) return new int[]{0, 0};
        else return new int[]{heap.last(), heap.first()};
    }
}
