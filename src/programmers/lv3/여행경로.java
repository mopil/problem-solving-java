package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        solution(tickets);
        System.out.println(answer);
    }

    static boolean[] ticketUsed;
    static ArrayList<String> answer = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        ticketUsed = new boolean[tickets.length];

        dfs("ICN", "ICN", 0 , tickets);

        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    static void dfs(String now, String nodes, int count, String[][] tickets) {
        if (count == tickets.length) {
            answer.add(nodes);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!ticketUsed[i] && tickets[i][0].equals(now)) {
                ticketUsed[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1], count+1, tickets);
                ticketUsed[i] = false;
            }
        }
    }


}
