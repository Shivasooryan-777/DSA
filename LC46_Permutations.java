import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> currentList = new ArrayList<>();
        for (int num : nums) {
            currentList.add(num);
        }

        backtrack(nums.length, currentList, result, 0);
        return result;
    }

    private void backtrack(int n, List<Integer> current, List<List<Integer>> result, int start) {
        if (start == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < n; i++) {
            // Swap to place current[i] at start position
            swap(current, start, i);
            backtrack(n, current, result, start + 1);
            // Backtrack: swap back
            swap(current, start, i);
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
