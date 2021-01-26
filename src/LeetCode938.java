public class LeetCode938 {
    public static int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {

        sum = 0;

        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high){
        if (node == null) return;

        dfs(node.left, low, high);
        if (node.val >= low && node.val <= high){
            sum += node.val;
        }
        dfs(node.right, low, high);
    }
}

/**

 runtime 1.50ms, memory usage 47.3 MB
 runtime beats 53.11% of java submissions
 memory usage beats 30.61% of java submissions

 **/