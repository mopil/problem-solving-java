package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        String[] words2 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 2;
        int[] result = solution(n, words);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int n, String[] words) {
        int round = 1;
        int curTurn = 1;
        List<String> usedWords = new ArrayList<>();
        usedWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String lastWord = usedWords.get(usedWords.size()-1);
            char lastChar = lastWord.toCharArray()[lastWord.length()-1];
            String curWord = words[i];
            char curFirstChar = curWord.toCharArray()[0];
            if (i >= n) {
                if (i % n == 0) round++;
            }
            curTurn++;
            if (curTurn > n) curTurn = 1;
            if (usedWords.contains(curWord) || lastChar != curFirstChar) {
                return new int[]{curTurn, round};
            }
            usedWords.add(words[i]);
//            System.out.println("index: " + i + " round: " + round + " curTurn: " + curTurn + " lastWord: " + lastWord + "/curWord: " + curWord);
        }
        return new int[]{0 ,0};
    }
}
