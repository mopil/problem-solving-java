import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static <T> List<List<T>> getCombination(List<T> arr, int r) {
        boolean[] visited = new boolean[arr.size()];
        List<List<T>> result = new ArrayList<>();
        normalCombination(arr, visited, 0, arr.size(), r, result);
        return result;
    }
    private static <T> void normalCombination(List<T> arr, boolean[] visited, int start, int n, int r, List<List<T>> result) {
        if (r == 0) {
            List<T> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) if (visited[i]) temp.add(arr.get(i));
            result.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            normalCombination(arr, visited, i + 1, n, r - 1, result);
            visited[i] = false;
        }
    }

    public static <T> List<List<T>> getRepeatableCombination(List<T> arr, int r) {
        List<List<T>> result = new ArrayList<>();
        repeatableCombination(arr, new Object[r], 0, 0, r, result);
        return result;
    }
    private static <T> void repeatableCombination(List<T> arr, Object[] out, int start, int depth, int r, List<List<T>> result) {
        if (depth == r) {
            List<T> temp = new ArrayList<>();
            for (Object o : out) temp.add((T) o);
            result.add(temp);
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            out[depth] = arr.get(i);
            repeatableCombination(arr, out, i, depth + 1, r, result);
        }
    }
}
