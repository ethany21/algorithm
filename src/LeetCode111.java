public class LeetCode111 {

    public int minDepth(TreeNode root) {

        if(root == null){return 0;}

        return dfs(root);
    }

    public int dfs(TreeNode node){

        if(node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.min(dfs(node.left), dfs(node.right)) + 1;
        }
}