package programmers.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 뉴스_클러스터링_1 {
    public static void main(String[] args) {
//        String str1 = "FRANCE";
//        String str2 = "french";
//        String str1 = "handshake";
//        String str2 = "shake hands";
//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";
//        String str1 = "E=M*C^2";
//        String str2 = "e=m*c^2";
        String str1 = "abab";
        String str2 = "baba";
        int r = solution(str1, str2);
        System.out.println(r);
    }

    static List<String> makePair(String str) {
        List<String> result = new ArrayList<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String pair = str.substring(i, i + 2);
            String reduced = pair.replaceAll("[^a-z]", "");
            if (reduced.length() >= 2)
                result.add(pair);
        }
        return result;
    }

    static List<String> intersect(List<String> arr1, List<String> arr2) {
        List<String> big;
        List<String> small;
        if (arr1.size() > arr2.size()) {
            big = new ArrayList<>(arr1);
            small = new ArrayList<>(arr2);
        } else {
            big = new ArrayList<>(arr2);
            small = new ArrayList<>(arr1);
        }
        List<String> intersection = new ArrayList<>();
        for (String str : big) {
            if (small.contains(str)) {
                small.remove(str);
                intersection.add(str);
            }
        }
        return intersection;
    }

    public static int solution(String str1, String str2) {
        List<String> pairs1 = makePair(str1);
        List<String> pairs2 = makePair(str2);
        pairs1.sort(Comparator.naturalOrder());
        pairs2.sort(Comparator.naturalOrder());
        List<String> intersection = intersect(pairs1, pairs2);
        List<String> union = new ArrayList<>(pairs1);
        union.addAll(pairs2);
        for (String c : intersection) {
            union.remove(c);
        }
//        System.out.println(pairs1);
//        System.out.println(pairs2);
//        System.out.println(intersection);
//        System.out.println(union);
        if (union.size() == 0) return 65536;
        double rate = (double) intersection.size() / union.size();
        return (int) Math.floor(rate * 65536);
    }
}
