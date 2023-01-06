package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
//        String skill = "ABC";
//        String[] skill_trees = {"AC", "BDC", "BDA", };
        int r = solution(skill, skill_trees);
        System.out.println(r);
    }

//    public static int solution(String skill, String[] skill_trees) {
//        int result = 0;
//        System.out.println(Arrays.toString(skill_trees));
//        for (String skillTree : skill_trees) {
//
//            char[] skillTreeManual = skill.toCharArray();
//            char rootSkill = skillTreeManual[0];
//            char secondSkill = skillTreeManual[1];
//
//            int lastIndex = skillTree.indexOf(rootSkill);
//            boolean isPossible = true;
//            char nextSkill = secondSkill;
//            for (int i = 0; i < skill.length(); i++) {
//                char curSkill = skillTreeManual[i];
//                if (i >= 1 && i < skill.length() - 1 && nextSkill != curSkill) {
//                    isPossible = false;
//                    break;
//                }
//                int curIndex = skillTree.indexOf(curSkill);
//                if ((lastIndex == -1 && curSkill == secondSkill)
////                        || curIndex == -1 && lastIndex != -1
//                        || ((lastIndex > curIndex) && curIndex != -1)) {
//                    isPossible = false;
//                    break;
//                }
//                nextSkill = skillTreeManual[i+1];
//                lastIndex = curIndex;
//            }
//
//            if (isPossible) {
//                System.out.println("스킬 순서 : " + skill);
//                System.out.println("스킬트리 : " + skillTree);
//                result++;
//                for (char c : skillTree.toCharArray()) {
//                    if (skill.contains(String.valueOf(c))) System.out.print("|" + c + "| -> ");
//                    else System.out.print(c + " -> ");
//                }
//                System.out.println();
//            }
//        }
//        return result;
//    }

    static int solution(String skill, String[] skill_trees) {
        List<String> trim = new ArrayList<>();
        for (String skillTree : skill_trees) {
            String temp = "";
            for (char c : skillTree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) temp += c;
            }
            trim.add(temp);
        }
        System.out.println(trim);

        // trim 에서 rule 에 대한 인덱스 추출
        List<List<Integer>> indexList = new ArrayList<>();
        for (String t : trim) {
            List<Integer> index = new ArrayList<>();
            for (char c : t.toCharArray()) {
                int idx = skill.indexOf(c);
                if (idx != -1) index.add(idx);
            }
            indexList.add(index);
        }
        int result = 0;
        // 0 부터 순차적인지 검사
        for (List<Integer> indexes : indexList) {
            boolean flag = true;
            for (int i = 0 ; i<indexes.size(); i++) {
                if (i != indexes.get(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        System.out.println(indexList);
        return result;
    }
}
