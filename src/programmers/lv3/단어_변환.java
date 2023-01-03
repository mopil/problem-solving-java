package programmers.lv3;

import java.util.*;

public class 단어_변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"cog", "log", "lot", "dog", "dot", "hot"};
//        String[] words = {"hop", "bob", "hot", "hog", "cog"};
        int r = solution(begin, target, words);
        System.out.println(r);
    }

    // 결과값 저장 (최소 방문 횟수)
    static int result = Integer.MAX_VALUE;
    static Map<String, Boolean> visited = new HashMap<>();

    public static int solution(String begin, String target, String[] words) {
        // 변환할 수 없으면 0 반환
        if ((!Arrays.asList(words).contains(target))) return 0;

        // 단어 방문 여부를 저장할 map
        for (String word : words) visited.put(word, false);

        dfs(begin, target, words, 0);

        // dfs를 종료하면 result에 값이 저장되어 있음
        return result;
    }

    static boolean isChangeable(String from, String to, String[] words) {
        int c = 0;
        // 모든 단어의 길이가 동일하다는 조건때문에 아무 길이로 비교 가능
        for (int i = 0; i < from.length(); i++)
            if (from.charAt(i) == to.charAt(i)) c++;

        // 바꿀 수 있는 경우 = 두 단어가 한 글자만 다르고 words에 포함
        return c >= from.length() - 1 && Arrays.asList(words).contains(to);
    }

    static void dfs(String cur, String target, String[] words, int depth) {
        if (cur.equals(target)) {
            // target값과 동일하면 지금까지 내려온 depth를 비교한다
            result = Math.min(result, depth);
            System.out.println("-------------");
        }
        else {
            // 현재 단어 방문 처리
            visited.put(cur, true);
            for (String word : words) {
                // 방문 하지 않았고, 변경가능한 단어를 탐색
                if (!visited.get(word) && isChangeable(cur, word, words)) {
                    System.out.println(cur + " -> " + word);
                    dfs(word, target, words, depth + 1);
                }
            }
        }
    }
}
