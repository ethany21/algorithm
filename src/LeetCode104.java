public class LeetCode104 {

    public int maxDepth(TreeNode node){
        if (node == null) {return 0;}

        return dfs(node, 0);
    }

    public int dfs(TreeNode node, int depth){
        if(node == null){
            return depth;
        }

        return Math.max(dfs(node.left, depth+1), dfs(node.right, depth+1));
    }

}
