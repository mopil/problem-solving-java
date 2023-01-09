package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        };
        int r = solution(clothes);
        System.out.println(r);
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> dict = new HashMap<>();
        for (String[] cloth : clothes) {
            String key = cloth[1];
            if (!dict.containsKey(key)) dict.put(key, 0);
            dict.put(key, dict.get(key) + 1);
        }

        int result = 1;
        for (String key : dict.keySet()) {
            result *= (dict.get(key) + 1);
        }
        return result - 1;
    }
}
