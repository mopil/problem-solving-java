package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x; int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x:" + this.x + ", y:" + this.y;
    }
}

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int row = maps.length;
        int col = maps[0].length;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (maps[nx][ny] == 0) continue;
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] += maps[node.x][node.y];
                    Node newNode = new Node(nx, ny);
                    q.offer(newNode);
                }
            }
        }
        int r= maps[row-1][col-1] == 1 ? 1 : maps[row-1][col-1];
        System.out.println(r);
    }
}
