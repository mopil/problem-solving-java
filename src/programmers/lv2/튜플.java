package programmers.lv2;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        String s = "{{20,111},{111}}";
//        String s = "{{123}}";
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        solution(s);

//        List<Integer> r = solution(s);
//        System.out.println(r);
    }

    public static List<Integer> solution(String s) {
        List<List<Integer>> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, "}");
        while (st.hasMoreTokens()) {
            String s1 = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(s1, "{,");
            List<Integer> temp = new ArrayList<>();
            while (st2.hasMoreTokens()) {
                temp.add(Integer.parseInt(st2.nextToken()));
            }
            result.add(temp);
        }
        result.sort(Comparator.comparingInt(List::size));
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> set : result) {
            for (Integer integer : set) {
                if (!answer.contains(integer))
                    answer.add(integer);
            }
        }
        return answer;
    }

}
