public class LeetCode938better {


    public static int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high){
        if (node == null) return;
        dfs(node.left, low, high);
        if (node.val > high) return;
        if (node.val >= low && node.val <= high){
            sum += node.val;
        }
        dfs(node.right, low, high);
    }

}


/**
 
 이전 938 솔루션에 더해,
 high 보다 노드의 값이 더 높을 경우 재귀를 종료했다
 따라서 트리 전체를 더 탐색하지 않아도 된다
 
 runtime between (0.475, 0.5) memory usage 47.5 MB
 runtime beats 100% of java submissions
 memory usage beast 17.75% of java submissions

 **/
