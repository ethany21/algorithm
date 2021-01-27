
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class LeetCode1302 {
    public static Map<Integer, Integer> box;
    public int deepestLeavesSum(TreeNode root) {
        box = new HashMap<>();
        int max = 0;
        int sum = 0;
        dfs(root, 0);

        for(Entry<Integer, Integer> entry: box.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }

        for(Entry<Integer, Integer> entry: box.entrySet()){
            if (entry.getValue() == max){
                sum += entry.getKey();
            }
        }
        return sum;
    }
    public void dfs(TreeNode node, int depth){
        if (node == null) return;

        if(box.containsKey(node.val)){
            int compare = box.get(node.val);
            if (compare < depth){
                box.put(node.val, depth);
            }
        } else{
            box.put(node.val, depth);
        }
        depth++;
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
/**
 runtime 3 ms, memory usage 47.5 MB
 runtime beats 45.67% of java submissions
 memory usage beats 15.31% of java submissions
 **/